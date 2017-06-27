package com.lmr.cglibproxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class TimeCglib implements MethodInterceptor{
	
	private Object target;
	
	public Object getProxy(Class<?> cls){
		
		Enhancer enhancer=new Enhancer();
		enhancer.setSuperclass(cls);
		enhancer.setCallback(this);
		
		return enhancer.create();
	}
	
	public Object getProxy(Object target){
		
		this.target=target;
		
		Enhancer enhancer=new Enhancer();
		enhancer.setSuperclass(target.getClass());
		enhancer.setCallback(this);
		
		return enhancer.create();
		
	}
	

	@Override
	public Object intercept(Object object, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
		
		System.out.println("火车开始行驶...");

		long starttime = System.currentTimeMillis();
		
//		methodProxy.invokeSuper(object, objects);
		method.invoke(target);
		
		long endtime = System.currentTimeMillis();

		System.out.println("火车结束行驶...  行驶时间: " + (endtime - starttime) + " 毫秒");
		
		return null;
	}

}
