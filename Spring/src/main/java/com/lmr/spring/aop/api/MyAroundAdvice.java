package com.lmr.spring.aop.api;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyAroundAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("MyAroundAdvice  1  "+invocation.getMethod().getName()+"  "+invocation.getStaticPart().getClass().getName());
		Object object=invocation.proceed();
		System.out.println("MyAroundAdvice  2  " + object);
		return object;
	}

}
