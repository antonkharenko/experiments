package com.playtech;

public class ThreadSafeLazySingeltonDoubleChecking {
	
	private static volatile ThreadSafeLazySingeltonDoubleChecking instance;
	
	private ThreadSafeLazySingeltonDoubleChecking() {
	}

	public static ThreadSafeLazySingeltonDoubleChecking getInstance() {
		if (instance == null) {
			synchronized(ThreadSafeLazySingeltonDoubleChecking.class) {
				if (instance == null) {
					instance = new ThreadSafeLazySingeltonDoubleChecking();
				}
			}
		}
		
		return instance;
	}
}
