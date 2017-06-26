package com.lmr.proxymodel;

public class CarTimeProxy implements MoveAble{

	private MoveAble ma;
	
	public CarTimeProxy(MoveAble ma) {
		super();
		this.ma = ma;
	}

	@Override
	public void move() {
		
		System.out.println("汽车开始行驶...");

		long starttime = System.currentTimeMillis();
		
		ma.move();
		
		long endtime = System.currentTimeMillis();

		System.out.println("汽车结束行驶...  行驶时间: " + (endtime - starttime) + " 毫秒");
		
	}

	
	
}
