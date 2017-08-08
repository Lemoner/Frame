package com.lmr.strategy;

/**
 * Ѽ������
 */
public class DuckThree extends Duck{

	public DuckThree() {
		super();
		super.setSayingStrategy(new SayingStrategyThree());
	}
	
	@Override
	public void diaplay() {
		System.out.println("I am Duck Number Three");
	}

}
