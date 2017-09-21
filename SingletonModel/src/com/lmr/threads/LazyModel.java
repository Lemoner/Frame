package com.lmr.threads;

/**
 * ����ģʽ
 */
public class LazyModel {

	private int id;
	
	//1.�����췽��˽�л����������ⲿֱ�Ӵ�������
	private LazyModel(){
		this.id=1;
	}
	
	//2.�������Ψһʵ����ʹ��private static���Σ�ʹ���Ϊ˽�о�̬����
	private static LazyModel lazyModel;

	//3.�ṩһ�����ڻ�ȡʵ���ķ�����ʹ��private static����
	public static LazyModel getLazyModel() {
		
		//ģ��ҵ�������
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(lazyModel==null){
			//ģ��ҵ�������
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			DCL˫���������
			synchronized (LazyModel.class) {
				if(lazyModel==null){
					lazyModel=new LazyModel();
				}
			}
//			lazyModel=new LazyModel();
		}
		
		return lazyModel;
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "LazyModel [id=" + id + "]";
	}
	
}
