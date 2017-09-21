package com.lmr.threads;

public class LazyModelThread extends Thread{

	@Override
	public void run() {
		
		System.out.println(Thread.currentThread().getName()+" get lazymodel is "+LazyModel.getLazyModel().hashCode()+" time is "+System.currentTimeMillis());
		
	}

}
