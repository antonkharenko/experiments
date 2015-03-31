package antonkharenko.zookeeper.synchronizers;

import java.nio.ByteBuffer;
import java.util.List;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.data.Stat;

/**
 * A producer-consumer queue is a distributed data structure that group of
 * processes use to generate and consume items. Producer processes create new
 * elements and add them to the queue. Consumer processes remove elements from
 * the list, and process them. In this implementation, the elements are simple
 * integers. The queue is represented by a root node, and to add an element to
 * the queue, a producer process creates a new node, a child of the root node.
 */
public class Queue extends SyncPrimitive {

	/**
	 * Constructor of producer-consumer queue
	 * 
	 * @param address
	 * @param name
	 */
	Queue(String address, String name) {
		super(address);
		this.root = name;
		// Create ZK node name
		if (zk != null) {
			try {
				Stat s = zk.exists(root, false);
				if (s == null) {
					zk.create(root, new byte[0], Ids.OPEN_ACL_UNSAFE,
							CreateMode.PERSISTENT);
				}
			} catch (KeeperException e) {
				System.out
						.println("Keeper exception when instantiating queue: "
								+ e.toString());
			} catch (InterruptedException e) {
				System.out.println("Interrupted exception");
			}
		}
	}

	/**
	 * Add element to the queue.
	 * 
	 * A producer process calls "produce()" to add an element to the queue, and
	 * passes an integer as an argument. To add an element to the queue, the
	 * method creates a new node using "create()", and uses the SEQUENCE flag to
	 * instruct ZooKeeper to append the value of the sequencer counter
	 * associated to the root node. In this way, we impose a total order on the
	 * elements of the queue, thus guaranteeing that the oldest element of the
	 * queue is the next one consumed.
	 * 
	 * @param i
	 * @return
	 */
	boolean produce(int i) throws KeeperException, InterruptedException {
		ByteBuffer b = ByteBuffer.allocate(4);
		byte[] value;

		// Add child with value i
		b.putInt(i);
		value = b.array();
		zk.create(root + "/element", value, Ids.OPEN_ACL_UNSAFE,
				CreateMode.PERSISTENT_SEQUENTIAL);

		return true;
	}

	/**
	 * Remove first element from the queue.
	 * 
	 * To consume an element, a consumer process obtains the children of the
	 * root node, reads the node with smallest counter value, and returns the
	 * element. Note that if there is a conflict, then one of the two contending
	 * processes won't be able to delete the node and the delete operation will
	 * throw an exception.
	 * 
	 * A call to getChildren() returns the list of children in lexicographic
	 * order. As lexicographic order does not necessary follow the numerical
	 * order of the counter values, we need to decide which element is the
	 * smallest. To decide which one has the smallest counter value, we traverse
	 * the list, and remove the prefix "element" from each one.
	 * 
	 * @return
	 * @throws KeeperException
	 * @throws InterruptedException
	 */
	int consume() throws KeeperException, InterruptedException {
		int retvalue = -1;
		Stat stat = null;

		// Get the first element available
		while (true) {
			synchronized (mutex) {
				List<String> list = zk.getChildren(root, true);
				if (list.size() == 0) {
					System.out.println("Going to wait");
					mutex.wait();
				} else {
					Integer min = new Integer(list.get(0).substring(7));
					for (String s : list) {
						Integer tempValue = new Integer(s.substring(7));
						// System.out.println("Temporary value: " + tempValue);
						if (tempValue < min)
							min = tempValue;
					}
					System.out.println("Temporary value: " + root + "/element"
							+ min);
					byte[] b = zk.getData(root + "/element" + min, false, stat);
					zk.delete(root + "/element" + min, 0);
					ByteBuffer buffer = ByteBuffer.wrap(b);
					retvalue = buffer.getInt();

					return retvalue;
				}
			}
		}
	}
}
