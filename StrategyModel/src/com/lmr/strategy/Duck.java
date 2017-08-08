package com.lmr.strategy;

/**
 * ����Ѽ����
 */
public abstract class Duck {
	
	/**
	 * Ѽ��������ֵĳ��󷽷�
	 */
	public abstract void diaplay();
	
	/**
	 * Ѽ�ӵĽ������Զ���
	 */
	public SayingStrategy sayingStrategy;
	
	/**
	 * ���ò�ͬѼ�ӵĽ�������
	 * @param sayingStrategy	��������
	 */
	public void setSayingStrategy(SayingStrategy sayingStrategy) {
		this.sayingStrategy = sayingStrategy;
	}

	/**
	 * Ѽ�ӵĽ���������ͨ�����ø÷���ʵ�ֽ��������е�sayPerform()����
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
