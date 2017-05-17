package com.lmr.spring.bean;

import org.junit.Test;

import com.lmr.spring.base.UnitTestBase;

public class TestBeanAutowire extends UnitTestBase{

	public TestBeanAutowire() {
		super("classpath:spring-beanautowire.xml");
	}
	
	@Test
	public void testAutowire(){
		BeanAutowireService beanAutowireService=super.getBean("beanAutowireService");
		beanAutowireService.say("hello,Autowire");
	}
	
}
