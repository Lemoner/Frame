package com.lmr.extrinsic;

/**
 * 抽象聚集
 */
public abstract class Aggregate {

	/**
	 * 工厂方法，创建相应迭代子对象的接口
	 * @return	迭代子对象
	 */
	public abstract Iterator createIterator();
	
}
