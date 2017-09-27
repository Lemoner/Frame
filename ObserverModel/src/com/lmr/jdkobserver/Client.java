package com.lmr.jdkobserver;

public class Client {

	public static void main(String[] args) {
		
		SubjectEntity subject=new SubjectEntity();
		
		ObserverEntity observer1=new ObserverEntity("UserA");
		ObserverEntity observer2=new ObserverEntity("UserB");
		
		subject.addObserver(observer1);
		subject.addObserver(observer2);
		
		subject.setContent("The weather is rain ! !");
		
	}
	
}
