package com.lmr.threads;

/**
 * ����ģʽ
 */
public class HungryModel {

	private int id;
	
	//1.�����췽��˽�л����������ⲿֱ�Ӵ�������
	private HungryModel() {
		this.id=1;
	}
	
	//2.�������Ψһʵ����ʹ��private static���Σ�ʹ���Ϊ˽�о�̬����
	private static HungryModel hungryModel=new HungryModel();

	//3.�ṩһ�����ڻ�ȡʵ���ķ�����ʹ��private static����
	public static HungryModel getHungryModel() {
		//ģ��ҵ��������
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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