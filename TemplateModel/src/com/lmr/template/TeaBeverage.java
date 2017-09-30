package com.lmr.template;

/**
 * ������
 */
public class TeaBeverage extends Beverage{

	/**
	 * �Ƿ���ӵ�ζ��
	 */
	private boolean isAdd=true;
	
	/**
	 * Ĭ�Ϲ��췽��
	 */
	public TeaBeverage() {
	}
	
	/**
	 * ���ι��췽��
	 * @param isAdd	�Ƿ���ӵ�ζ��
	 */
	public TeaBeverage(Boolean isAdd) {
		this.isAdd=isAdd;
	}
	
	@Override
	protected void brew() {
		System.out.println("��80�ȵ���ˮ���ݲ�Ҷ5����");
	}

	@Override
	protected void addCondiments() {
		System.out.println("��������");
	}

	@Override
	protected boolean doJudgeIsAddCondiments() {
		return isAdd;
	}

	@Override
	protected void startProduce() {
		System.out.println("׼������������...");
	}

	@Override
	protected void endProduce() {
		System.out.println("�������������!!!");
	}

}
