package com.lmr.strategy;

/**
 * 鸭子一号
 */
public class DuckOne extends Duck{
	
	/**
	 * 构造方法，同时设置该鸭子的叫声策略
	 */
	public DuckOne() {
		super();
		super.setSayingStrategy(new SayingStrategyOne());
		super.setFlyingStrategy(new FlyingOne());
	}
	
	@Override
	public void diaplay() {
		System.out.println("I am Duck Number One");
	}
	
}
