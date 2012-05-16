package com.playtech;

public class ThreadSafeLazySingelton {
	
	private static volatile ThreadSafeLazySingelton instance;
	
	private ThreadSafeLazySingelton() {
	}

	public static ThreadSafeLazySingelton getInstance() {
		if (instance == null) {
			synchronized(ThreadSafeLazySingelton.class) {
				if (instance == null) {
					instance = new ThreadSafeLazySingelton();
				}
			}
		}
		
		return instance;
	}
	
	public void check() {
		System.out.println("ThreadSafeLazySingelton check");
	}
	
	public static void main(String[] args) {
		ThreadSafeLazySingelton.getInstance().check();
	}
}
