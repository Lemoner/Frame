package com.lmr.proxymodel;

import org.junit.Test;

public class TestProxy {

	@Test
	public void TestCarMove(){
		
		Car car=new Car();
		car.move();
		
	}
	
	@Test
	public void TestCarMove2(){
		
		MoveAble ma=new Car2();
		ma.move();
		
	}
	
	@Test
	public void TestCarMove3(){
		
		Car c=new Car();
		MoveAble ma=new Car3(c);
		ma.move();
		
	}
	
	@Test
	public void TestCarMove4(){
		
		Car car=new Car();
		CarTimeProxy ctp=new CarTimeProxy(car);
		CarLogProxy clp=new CarLogProxy(ctp);
		clp.move();
		
	}
	
}
