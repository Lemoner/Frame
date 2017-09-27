package com.lmr.myobserver_pull;

/**
 * 观察者实体
 */
public class ObserverEntity implements Observer{

	private String name;
	private String content;
	
	public ObserverEntity(String name) {
		this.name=name;
	}
	
	@Override
	public void updateInfo(String content) {
		this.content=content;
		System.out.println(name+" is receive "+content);
	}

}
