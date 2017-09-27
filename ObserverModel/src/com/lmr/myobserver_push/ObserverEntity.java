package com.lmr.myobserver_push;

/**
 * �۲���ʵ��
 */
public class ObserverEntity implements Observer{

	private String name;
	private String content;
	
	public ObserverEntity(String name) {
		this.name=name;
	}
	
	@Override
	public void updateInfo(Subject subject) {
		content=((SubjectEntity)subject).getContent();
		System.out.println(name+" is receive "+content);
	}

}
