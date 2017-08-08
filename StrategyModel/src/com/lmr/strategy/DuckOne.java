package com.lmr.strategy;

/**
 * Ѽ��һ��
 */
public class DuckOne extends Duck{
	
	/**
	 * ���췽����ͬʱ���ø�Ѽ�ӵĽ�������
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
