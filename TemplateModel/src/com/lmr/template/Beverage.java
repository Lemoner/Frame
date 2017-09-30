package com.lmr.template;

/**
 * ����
 */
abstract class Beverage {

	/**
	 * ��������ģ��
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
	 * ��ʼ��������
	 */
	protected abstract void startProduce();

	/**
	 * �����������
	 */
	protected abstract void endProduce();

	/**
	 * �����ģ��ж��Ƿ���ӵ�ζ�ϣ����ӷ�����
	 * @return	true	���
	 * 			false	�����
	 */
	protected boolean doJudgeIsAddCondiments() {
		return true;
	}

	/**
	 * ����һ����ˮ
	 */
	private void boilWater() {
		System.out.println("��ˮ���");
	}

	/**
	 * ���������������
	 */
	protected abstract void brew();

	/**
	 * �������������ϵ��뱭��
	 */
	private void pourInCup() {
		System.out.println("�����ϵ��뱭��");
	}

	/**
	 * �����壺��ӵ�ζ��
	 */
	protected abstract void addCondiments();
	
}
