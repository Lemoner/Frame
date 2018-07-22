package com.lmr.simple;

public class Client {

	public static void main(String[] args) {
		
		Context context=new Context();
		
		State statea=new ConcreteStateA();
		State stateb=new ConcreteStateB();
		
		context.setState(statea);
		context.request();
		
		context.setState(stateb);
		context.request();
		
	}
	
}
