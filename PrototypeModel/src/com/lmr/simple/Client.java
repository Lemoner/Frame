package com.lmr.simple;

public class Client {

	public static void main(String[] args){
		
//		TestOne();
		
		TestTwo();
		
	}

	private static void TestOne() {
		ConcretePrototype prototype=new ConcretePrototype("Jack",11);
		ConcretePrototype copyprototype=(ConcretePrototype) prototype.clone();
		
		System.out.println(prototype.toString());
		System.out.println(copyprototype.toString());
	}

	private static void TestTwo() {
		ConcretePrototype prototype1=new ConcretePrototype("Jane",11);
		ConcretePrototype prototype2=new ConcretePrototype("Mack",18);
		
		PrototypeManager.addPrototype("p1", prototype1);
		PrototypeManager.addPrototype("p2", prototype2);
		
		System.out.println(PrototypeManager.getPrototype("p1").clone().toString());
		System.out.println(PrototypeManager.getPrototype("p2").clone().toString());
		System.out.println(PrototypeManager.getPrototype("p1").clone().toString());
		System.out.println(PrototypeManager.getPrototype("p2").clone().toString());
		
	}
	
}
