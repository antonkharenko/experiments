package antonkharenko.zookeeper.curator;

import java.util.concurrent.TimeUnit;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

public class DistributedLock {

	public void main(String[] args) throws Exception {
		String zookeeperConnectionString = "127.0.0.1:2181";
		String lockPath = "/pt.openapi.lock";
		RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
		CuratorFramework client = CuratorFrameworkFactory.newClient(zookeeperConnectionString, retryPolicy);
		client.start();
		
		InterProcessMutex lock = new InterProcessMutex(client, lockPath);
		if (lock.acquire(30, TimeUnit.SECONDS)) {
			try {
				// do some work inside of the critical section here
			} finally {
				lock.release();
			}
		}
	}

}
