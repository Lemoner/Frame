package com.lmr.template;

/**
 * 咖啡饮料
 */
public class CoffeeBeverage extends Beverage{

	@Override
	public void brew() {
		System.out.println("用沸水冲泡咖啡");
	}

	@Override
	protected void addCondiments() {
		System.out.println("加入糖和牛奶");
	}
	
	@Override
	protected void startProduce() {
		System.out.println("准备生产咖啡饮料...");
	}

	@Override
	protected void endProduce() {
		System.out.println("咖啡饮料生产完成!!!");
	}

}
