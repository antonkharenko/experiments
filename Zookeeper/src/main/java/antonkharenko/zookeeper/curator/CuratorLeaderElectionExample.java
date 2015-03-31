package antonkharenko.zookeeper.curator;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.leader.LeaderSelector;
import org.apache.curator.framework.recipes.leader.LeaderSelectorListener;
import org.apache.curator.framework.state.ConnectionState;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CuratorLeaderElectionExample implements Runnable {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CuratorLeaderElectionExample.class);
	
	private volatile boolean stopFlag;
	
	private Object leaderMutex = new Object();
	
	public CuratorLeaderElectionExample() {
		// Initialize and start curator zookeeper client
		String zookeeperConnectionString = "127.0.0.1:2181";
		RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
		final CuratorFramework client = CuratorFrameworkFactory.newClient(zookeeperConnectionString, retryPolicy);
		client.start();
		
		// Create test node
		/*
		try {
			client.create().forPath("/test", "Hello World!".getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
		
		// Create leader selector
		String leaderPath = "/pt.openapi.leader";
		
		LeaderSelectorListener listener = new LeaderSelectorListener() {
		    public void takeLeadership(CuratorFramework client) throws Exception {
		        // this callback will get called when you are the leader
		        // do whatever leader work you need to and only exit
		        // this method when you want to relinquish leadership
		    	
		    	LOGGER.debug("Take leadership: client={}", client);
		    	
		    	try {
		            synchronized (leaderMutex) {
		                while (!stopFlag) {
		                	LOGGER.debug("Wait leader thread");
		                	leaderMutex.wait();
		                }
		            }
		        } catch (InterruptedException e) {
		        }
		    }

		    public void stateChanged(CuratorFramework client, ConnectionState newState) {
		        // see https://github.com/Netflix/curator/wiki/Errors
		        // You always need to be aware that connections to ZK can fail
		    	
		    	LOGGER.debug("State changed: client={}, newState={}", client, newState);
		    }
		};
		
		LeaderSelector selector = new LeaderSelector(client, leaderPath, listener);
		selector.autoRequeue();  // not required, but this is behavior that you will probably expect
		selector.start();
	}
	
	public static void main(String[] args) {
		try {
            new CuratorLeaderElectionExample().run();
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
