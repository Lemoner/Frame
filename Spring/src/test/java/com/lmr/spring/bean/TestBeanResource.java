package com.lmr.spring.bean;

import java.io.IOException;

import org.junit.Test;

import com.lmr.spring.base.UnitTestBase;

public class TestBeanResource extends UnitTestBase{

	public TestBeanResource() {
		super("classpath:spring-beanresource.xml");
	}
	
	@Test
	public void testResource() throws IOException{
		BeanResource beanResource=super.getBean("beanResource");
		beanResource.resource();
	}
	
}
