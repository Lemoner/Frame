package com.lmr.proxymodel;

public class Car2 extends Car {

	@Override
	public void move() {

		System.out.println("汽车开始行驶...");

		long starttime = System.currentTimeMillis();

		super.move();

		long endtime = System.currentTimeMillis();

		System.out.println("汽车结束行驶...  行驶时间: " + (endtime - starttime) + " 毫秒");
	}

}
