package com.lmr.threads;

public class HungryModelThread extends Thread{

	@Override
	public void run() {
		
		System.out.println(Thread.currentThread().getName()+" get hungrymodel is "+HungryModel.getHungryModel().hashCode()+" time is "+System.currentTimeMillis());
		
	}

}
