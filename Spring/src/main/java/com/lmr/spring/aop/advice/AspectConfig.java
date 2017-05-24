package com.lmr.spring.aop.advice;

import org.aspectj.lang.ProceedingJoinPoint;

public class AspectConfig {
	
	public void before(){
		System.out.println("AspectConfig before");
	}
	
	public void before2(){
		System.out.println("AspectConfig before2");
	}

	public void afterReturning(){
		System.out.println("AspectConfig afterReturning");
	}
	
	public void afterThrowing(){
		System.out.println("AspectConfig afterThrowing");
	}
	
	public void after(){
		System.out.println("AspectConfig after");
	}
	
	public void after2(){
		System.out.println("AspectConfig after2");
	}
	
	public Object around(ProceedingJoinPoint pjp){
		Object obj=null;
		try {
			System.out.println("AspectConfig around 1");
			obj = pjp.proceed();
			System.out.println("AspectConfig around 2");
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}
	
	public Object aroundParameter(ProceedingJoinPoint pjp,String name,int count){
		System.out.println("AspectConfig aroundParameter "+name+" "+count);
		Object obj=null;
		try {
			System.out.println("AspectConfig aroundParameter 1");
			obj = pjp.proceed();
			System.out.println("AspectConfig aroundParameter 2");
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}
	
}
