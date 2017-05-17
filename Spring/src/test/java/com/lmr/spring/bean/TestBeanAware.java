package com.lmr.spring.bean;

import org.junit.Test;

import com.lmr.spring.base.UnitTestBase;

public class TestBeanAware extends UnitTestBase{

	public TestBeanAware() {
		super("classpath:spring-beanaware.xml");
	}
	
	@Test
	public void testAware(){
		System.out.println("testAware : "+super.getBean("beanAware").hashCode());
	}
	
}
