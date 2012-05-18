package com.playtech;

public class ThreadSafeLazySingeltonHolder {
	
	private ThreadSafeLazySingeltonHolder() {
	}

	public static ThreadSafeLazySingeltonHolder getInstance() {
		return InstanceHolder.instance;
	}
	
	private static class InstanceHolder {
		private static ThreadSafeLazySingeltonHolder instance = new ThreadSafeLazySingeltonHolder();
	}
}
