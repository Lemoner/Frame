package com.lmr.strategy;

/**
 * Ѽ�Ӷ���
 */
public class DuckTwo extends Duck{

	public DuckTwo() {
		super();
		super.setSayingStrategy(new SayingStrategyTwo());
	}
	
	@Override
	public void diaplay() {
		System.out.println("I am Duck Number Two");
	}
	
}
