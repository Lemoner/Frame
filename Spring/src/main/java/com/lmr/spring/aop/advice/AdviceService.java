package com.lmr.spring.aop.advice;

public class AdviceService {

	public void say(){
		System.out.println("AdviceService say");
//		throw new RuntimeException();
	}
	
	public void sayParameter(String name, int count){
		System.out.println("AdviceService sayParameter "+name+" "+count);
	}
	
}
