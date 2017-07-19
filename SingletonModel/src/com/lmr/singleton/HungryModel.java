package com.lmr.singleton;

/**
 * 饿汉模式
 */
public class HungryModel {

	private int id;
	
	//1.将构造方法私有化，不允许外部直接创建对象
	private HungryModel() {
		this.id=1;
	}
	
	//2.创建类的唯一实例，使用private static修饰，使其变为私有静态变量
	private static HungryModel hungryModel=new HungryModel();

	//3.提供一个用于获取实例的方法，使用private static修饰
	public static HungryModel getHungryModel() {
		return hungryModel;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "HungryModel [id=" + id + "]";
	}
	
}
