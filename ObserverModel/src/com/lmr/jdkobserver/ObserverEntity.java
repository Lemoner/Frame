package com.lmr.jdkobserver;

import java.util.Observable;
import java.util.Observer;

/**
 * 观察者实体
 */
public class ObserverEntity implements Observer {

	String name;
	
	public ObserverEntity(String name) {
		this.name=name;
	}
	
	@Override
	public void update(Observable observable, Object object) {
		
		System.out.println(name+" push content is "+((SubjectEntity)observable).getContent());
		System.out.println(name+" pull content is "+(String)object);
		
	}

}
