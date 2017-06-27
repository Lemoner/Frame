package com.lmr.proxymodel;

import java.lang.reflect.Proxy;

import org.junit.Test;

import com.lmr.jdkproxy.LogHandler;
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
	
	@Test
	public void TestCarMove2(){
		
		Car car=new Car();
		
		LogHandler log=new LogHandler(car);
		Class<?> cls=car.getClass();
		MoveAble logma=(MoveAble)Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), log);
		
		TimeHandler time=new TimeHandler(logma);
		Class<?> logcls=logma.getClass();
		MoveAble timema=(MoveAble)Proxy.newProxyInstance(logcls.getClassLoader(), logcls.getInterfaces(), time);
		
		timema.move();
		
	}
	
}
