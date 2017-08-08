package com.lmr.strategy;

/**
 * 抽象鸭子类
 */
public abstract class Duck {
	
	/**
	 * 鸭子自身表现的抽象方法
	 */
	public abstract void diaplay();
	
	/**
	 * 鸭子的叫声策略对象
	 */
	public SayingStrategy sayingStrategy;
	
	/**
	 * 设置不同鸭子的叫声策略
	 * @param sayingStrategy	叫声策略
	 */
	public void setSayingStrategy(SayingStrategy sayingStrategy) {
		this.sayingStrategy = sayingStrategy;
	}

	/**
	 * 鸭子的叫声方法，通过调用该方法实现叫声策略中的sayPerform()方法
	 */
	public void say(){
		sayingStrategy.sayPerform();
	}
	
	public FlyingStrategy flyingStrategy;
	
	public void setFlyingStrategy(FlyingStrategy flyingStrategy) {
		this.flyingStrategy = flyingStrategy;
	}

	public void fly(){
		flyingStrategy.flyPerform();
	}
	
}
