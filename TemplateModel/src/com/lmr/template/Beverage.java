package com.lmr.template;

/**
 * 饮料
 */
abstract class Beverage {

	/**
	 * 生产饮料模板
	 */
	public final void produceBeverageTemple(){
		
		startProduce();
		
		boilWater();
		
		brew();
		
		pourInCup();
		
		if(doJudgeIsAddCondiments()){
			addCondiments();
		}
		
		endProduce();
	}

	/**
	 * 开始生产饮料
	 */
	protected abstract void startProduce();

	/**
	 * 饮料生产完成
	 */
	protected abstract void endProduce();

	/**
	 * 步骤四：判断是否添加调味料（钩子方法）
	 * @return	true	添加
	 * 			false	不添加
	 */
	protected boolean doJudgeIsAddCondiments() {
		return true;
	}

	/**
	 * 步骤一：烧水
	 */
	private void boilWater() {
		System.out.println("将水煮沸");
	}

	/**
	 * 步骤二：泡制饮料
	 */
	protected abstract void brew();

	/**
	 * 步骤三：将饮料倒入杯中
	 */
	private void pourInCup() {
		System.out.println("将饮料倒入杯中");
	}

	/**
	 * 步骤五：添加调味料
	 */
	protected abstract void addCondiments();
	
}
