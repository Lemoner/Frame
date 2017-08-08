package com.lmr.strategy;

public class TestDuck {

	public static void main(String[] args) {
		
		DuckOne duckOne=new DuckOne();
		duckOne.diaplay();
		duckOne.say();
		duckOne.fly();
		
		DuckTwo duckTwo=new DuckTwo();
		duckTwo.diaplay();
		duckTwo.say();
		
		DuckThree duckThree=new DuckThree();
		duckThree.diaplay();
		duckThree.say();
		
	}
	
}
