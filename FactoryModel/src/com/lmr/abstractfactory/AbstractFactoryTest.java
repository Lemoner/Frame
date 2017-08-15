package com.lmr.abstractfactory;

public class AbstractFactoryTest {

	public static void main(String[] args) {
		
		AbstractFactoryTestOne();
		
	}

	private static void AbstractFactoryTestOne() {
		
		PersonFactoryInterface personFactory1=new HNFactory();
		BoyInterface boy=personFactory1.getBoy();
		boy.show();
		
		PersonFactoryInterface personFactory2=new MCFactory();
		GirlInterface girl=personFactory2.getGril();
		girl.show();
		
	}
	
}
