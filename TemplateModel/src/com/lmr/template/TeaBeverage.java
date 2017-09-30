package com.lmr.template;

/**
 * 茶饮料
 */
public class TeaBeverage extends Beverage{

	/**
	 * 是否添加调味料
	 */
	private boolean isAdd=true;
	
	/**
	 * 默认构造方法
	 */
	public TeaBeverage() {
	}
	
	/**
	 * 带参构造方法
	 * @param isAdd	是否添加调味料
	 */
	public TeaBeverage(Boolean isAdd) {
		this.isAdd=isAdd;
	}
	
	@Override
	protected void brew() {
		System.out.println("用80度的热水浸泡茶叶5分钟");
	}

	@Override
	protected void addCondiments() {
		System.out.println("加入柠檬");
	}

	@Override
	protected boolean doJudgeIsAddCondiments() {
		return isAdd;
	}

	@Override
	protected void startProduce() {
		System.out.println("准备生产茶饮料...");
	}

	@Override
	protected void endProduce() {
		System.out.println("茶饮料生产完成!!!");
	}

}
