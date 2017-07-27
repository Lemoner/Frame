package com.lmr.proxymodel;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.junit.Test;

import com.lmr.myproxy.MyProxy;

public class TestMyProxy {

	@Test
	public void myproxy() throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException{
		
		Car car=new Car();
		
		MyProxy myProxy=new MyProxy();
		@SuppressWarnings("static-access")
		MoveAble ma=(MoveAble)myProxy.newProxyInstance(car,car.getClass().getInterfaces()[0]);
		
		ma.move();
	}
	
}
