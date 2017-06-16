package com.lmr.spring.aop.aspectj;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectConfig {

	@Pointcut("execution(* com.lmr.spring.aop.aspectj.MyBiz.*(..))")
	public void pointCut(){
	}
	
	@Before(value = "pointCut()")
	public void before(){
		System.out.println("AspectConfig before");
	}
	
	@Before("pointCut() && args(arg)")
	public void beforewithparam(String arg){
		System.out.println("AspectConfig beforewithparam : "+arg);
	}
	
	@AfterReturning(pointcut="pointCut()", returning="returnValue")
	public void afterreturning(Object returnValue){
		System.out.println("AspectConfig afterreturning : "+returnValue);
	}
	
	@AfterThrowing(pointcut="pointCut()", throwing="e")
	public void afterthrowing(Exception e){
		System.out.println("AspectConfig afterthrowing : "+e.getMessage());
	}
	
	@After("pointCut()")
	public void after(){
		System.out.println("AspectConfig after");
	}
	
	@Around("pointCut()")
	public Object around(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("AspectConfig around1");
		Object obj=pjp.proceed();
		System.out.println("AspectConfig around2");
		return obj;
	}
	
}
