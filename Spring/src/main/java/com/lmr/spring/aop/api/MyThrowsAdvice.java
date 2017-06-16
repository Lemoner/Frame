package com.lmr.spring.aop.api;

import java.lang.reflect.Method;

import org.springframework.aop.ThrowsAdvice;

public class MyThrowsAdvice implements ThrowsAdvice {

	public void afterThrowing(Exception e)throws Throwable{
		System.out.println("MyThrowsAdvice afterThrowing1  ");
	}
	
	public void afterThrowing(Method method, Object[] args, Object target, Exception e)throws Throwable{
		System.out.println("MyThrowsAdvice afterThrowing2  "+method.getName()+"  "+target.getClass().getName());
	}
	
}
