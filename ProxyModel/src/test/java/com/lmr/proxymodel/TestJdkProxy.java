package com.lmr.proxymodel;

import java.lang.reflect.Proxy;

import org.junit.Test;

import com.lmr.jdkproxy.TimeHandler;

public class TestJdkProxy {

	@Test
	public void TestCarMove(){
		
		Car car=new Car();
		TimeHandler handler=new TimeHandler(car);
		
		Class<?> c=car.getClass();
		
		MoveAble ma=(MoveAble)Proxy.newProxyInstance(c.getClassLoader(), c.getInterfaces(), handler);
		ma.move();
		
	}
	
}
