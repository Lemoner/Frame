package com.lmr.spring.bean;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import com.lmr.spring.base.UnitTestBase;

@RunWith(BlockJUnit4ClassRunner.class)
public class TestBeanLifeCycle extends UnitTestBase{

	public TestBeanLifeCycle() {
		
		super("classpath*:spring-beanlifecycle.xml");
		
	}
	
	@Test
	public void Test(){
		
		super.getBean("beanLifeCycle");
		
	}
	
}
