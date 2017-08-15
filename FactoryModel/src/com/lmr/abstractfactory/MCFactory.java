package com.lmr.abstractfactory;

/**
 * ʥ����װ����
 */
public class MCFactory implements PersonFactoryInterface {

	@Override
	public GirlInterface getGril() {
		return new MCGirl();
	}

	@Override
	public BoyInterface getBoy() {
		return new MCBoy();
	}

}
