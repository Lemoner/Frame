package com.lmr.abstractfactory;

/**
 * ������װ����
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
