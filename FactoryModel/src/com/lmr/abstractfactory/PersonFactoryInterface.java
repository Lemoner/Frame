package com.lmr.abstractfactory;

/**
 * 人物套装工厂接口
 */
public interface PersonFactoryInterface {

	/**
	 * 获取女孩套装
	 * @return	GirlInterface对象
	 */
	public GirlInterface getGril();
	
	/**
	 * 获取男孩套装
	 * @return	BoyInterface对象
	 */
	public BoyInterface getBoy();
	
}
