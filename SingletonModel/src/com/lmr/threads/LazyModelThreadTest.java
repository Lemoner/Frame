package com.lmr.threads;

public class LazyModelThreadTest {

	public static void main(String[] args) {
		
		LazyModelThread thread1=new LazyModelThread();
		LazyModelThread thread2=new LazyModelThread();
		LazyModelThread thread3=new LazyModelThread();
		
		thread1.setName("Thread1");
		thread2.setName("Thread2");
		thread3.setName("Thread3");
		
		System.out.println("now time is "+System.currentTimeMillis());
		
		thread1.start();
		thread2.start();
		thread3.start();
		
	}
	
}
