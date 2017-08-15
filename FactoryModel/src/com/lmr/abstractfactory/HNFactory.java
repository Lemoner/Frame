package com.lmr.abstractfactory;

/**
 * 新年套装工厂
 */
public class HNFactory implements PersonFactoryInterface {

	@Override
	public GirlInterface getGril() {
		return new HNGirl();
	}

	@Override
	public BoyInterface getBoy() {
		return new HNBoy();
	}

}
