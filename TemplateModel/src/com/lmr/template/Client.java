package com.lmr.template;

public class Client {

	public static void main(String[] args) {
		
		Beverage beverage1=new CoffeeBeverage();
		beverage1.produceBeverageTemple();
		
		System.out.println("---------------------");
		
		Beverage beverage2=new TeaBeverage();
		beverage2.produceBeverageTemple();
		
		System.out.println("---------------------");
		
		Beverage beverage3=new TeaBeverage(false);
		beverage3.produceBeverageTemple();
		
	}
	
}
