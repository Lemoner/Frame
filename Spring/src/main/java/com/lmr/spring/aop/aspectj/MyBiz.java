package com.lmr.spring.aop.aspectj;

import org.springframework.stereotype.Service;

@Service
public class MyBiz {

	public String save(String word){
		System.out.println("MyBiz save "+word);
//		throw new RuntimeException("MyBiz save RuntimeException");
		return "MyBiz save "+word;
	}
	
	
	
}
