package concurrency.in.practice.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
	private final Lock lock = new ReentrantLock();
	
	public void lockedMethodExaqmple() {
		lock.lock();
		try {
		    // update object state
		    // catch exceptions and restore invariants if necessary
		} finally {
		    lock.unlock();
		}
	}
}
