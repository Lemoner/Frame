package com.lmr.strategy;

/**
 * Ñ¼×Ó¶þºÅ
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
