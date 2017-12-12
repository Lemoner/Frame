package com.lmr.simple;

/**
 * 抽象原型
 */
public interface Prototype {

	/**
	 * 克隆方法
	 * @return	一个从自身克隆出来的对象
	 */
	public Object clone();
	
	public void setName(String name);
	
	public String getName();
	
	public void setAge(int age);
	
	public int getAge();
	
}
