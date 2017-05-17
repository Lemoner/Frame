package com.lmr.spring.bean;

public class BeanScope {
	
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void print(){
		System.out.println(this.hashCode()+" - - "+this.id);
	}

	public void say(){
		System.out.println("BeanScope say : "+this.hashCode());//通过hashCode()方法来判断通过容器生成的对象是否为同一个对象
	}
	
}
