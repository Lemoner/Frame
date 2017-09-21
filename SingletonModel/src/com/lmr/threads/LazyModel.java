package com.lmr.threads;

/**
 * 懒汉模式
 */
public class LazyModel {

	private int id;
	
	//1.将构造方法私有化，不允许外部直接创建对象
	private LazyModel(){
		this.id=1;
	}
	
	//2.声明类的唯一实例，使用private static修饰，使其变为私有静态变量
	private static LazyModel lazyModel;

	//3.提供一个用于获取实例的方法，使用private static修饰
	public static LazyModel getLazyModel() {
		
		//模拟业务处理操作
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(lazyModel==null){
			//模拟业务处理操作
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			DCL双检查锁机制
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
