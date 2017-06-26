package com.lmr.proxymodel;

public class CarLogProxy implements MoveAble{

	private MoveAble ma;
	
	public CarLogProxy(MoveAble ma) {
		super();
		this.ma = ma;
	}

	@Override
	public void move() {
		
		System.out.println("日志开始...");
		
		ma.move();
		
		System.out.println("日志结束...");
		
	}

}
