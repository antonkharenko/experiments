package antonkharenko.zookeeper.curator;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.leader.LeaderLatch;
import org.apache.curator.framework.recipes.leader.LeaderLatchListener;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CuratorLeaderLatchExample {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CuratorLeaderElectionExample.class);
	
	boolean stopFlag;
	
	public CuratorLeaderLatchExample() throws Exception {
		// Initialize and start curator zookeeper client
		String zookeeperConnectionString = "127.0.0.1:2181";
		RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
		final CuratorFramework client = CuratorFrameworkFactory.newClient(zookeeperConnectionString, retryPolicy);
		client.start();
		
		// Create leader selector
		String leaderPath = "/pt.openapi.leaderLatch";
		
		
		
		//for (int i = 0; i < 3; i++) {
			LeaderLatch leaderLatch = new LeaderLatch(client, leaderPath);
			leaderLatch.addListener(new LeaderLatchListener() {
				
				@Override
				public void notLeader() {
					System.out.println("Not leader");
					
				}
				
				@Override
				public void isLeader() {
					System.out.println("Is leader");
				}
			});
			
			System.out.println("Start leader latch");
			leaderLatch.start();
			
			System.out.println("Wait leadership");
			leaderLatch.await();
			
			System.out.println("Become leader and wait 5 seconds");
			Thread.sleep(5000);
			
			System.out.println("Release leadership");
			//leaderLatch.close();
		//}
		
	}
	
	public static void main(String[] args) {
		try {
            new CuratorLeaderLatchExample().run();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	public void run() {
    	LOGGER.debug("Start executor thread");
        try {
            synchronized (this) {
                while (!stopFlag) {
                	LOGGER.debug("Wait executor thread");
                    wait();
                }
            }
        } catch (InterruptedException e) {
        }
        LOGGER.debug("Stop executor thread");
    }
	
}
