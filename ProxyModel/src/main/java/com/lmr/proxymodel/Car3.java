package com.lmr.proxymodel;

public class Car3 implements MoveAble {

	private Car car;
	
	public Car3(Car car) {
		super();
		this.car = car;
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub

		System.out.println("汽车开始行驶...");

		long starttime = System.currentTimeMillis();
		
		car.move();
		
		long endtime = System.currentTimeMillis();

		System.out.println("汽车结束行驶...  行驶时间: " + (endtime - starttime) + " 毫秒");
		
	}

}
