package com.lmr.myobserver_push;

public class Client {

	public static void main(String[] args) {
		
		SubjectEntity subject=new SubjectEntity();
		
		ObserverEntity observer1=new ObserverEntity("UserA");
		ObserverEntity observer2=new ObserverEntity("UserB");
		
		subject.add(observer1);
		subject.add(observer2);
		
		subject.setContent("The weather is sun !");
		
	}
	
}
