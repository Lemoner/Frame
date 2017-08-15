package com.lmr.abstractfactory;

/**
 * Ê¥µ®Ì××°¹¤³§
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
