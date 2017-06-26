package com.lmr.proxymodel;

import java.util.Random;

public class Car implements MoveAble{

	@Override
	public void move() {
		
//		System.out.println("汽车开始行驶...");
//		
//		long starttime=System.currentTimeMillis();
		
		try {
			System.out.println("汽车行驶中...");
			Thread.sleep(new Random().nextInt(1000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		long endtime=System.currentTimeMillis();
//		
//		System.out.println("汽车结束行驶...  行驶时间: "+(endtime-starttime)+" 毫秒");
		
	}

}
