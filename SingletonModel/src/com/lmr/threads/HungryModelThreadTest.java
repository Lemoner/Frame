package com.lmr.threads;

public class HungryModelThreadTest {

	public static void main(String[] args) {
		
		HungryModelThread thread1=new HungryModelThread();
		HungryModelThread thread2=new HungryModelThread();
		HungryModelThread thread3=new HungryModelThread();
		
		thread1.setName("Thread1");
		thread2.setName("Thread2");
		thread3.setName("Thread3");
		
		System.out.println("now time is "+System.currentTimeMillis());
		
		thread1.start();
		thread2.start();
		thread3.start();
		
	}
	
}
