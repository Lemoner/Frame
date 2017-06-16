package com.lmr.spring.aop.api;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class MyAfterReturnAdvice implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("MyAfterReturnAdvice  "+method.getName()+"  "+target.getClass().getName()+"  "+returnValue);
	}

}
