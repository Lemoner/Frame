package com.lmr.template;

/**
 * ��������
 */
public class CoffeeBeverage extends Beverage{

	@Override
	public void brew() {
		System.out.println("�÷�ˮ���ݿ���");
	}

	@Override
	protected void addCondiments() {
		System.out.println("�����Ǻ�ţ��");
	}
	
	@Override
	protected void startProduce() {
		System.out.println("׼��������������...");
	}

	@Override
	protected void endProduce() {
		System.out.println("���������������!!!");
	}

}
