package com.lmr.spring.bean;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import com.lmr.spring.base.UnitTestBase;

@RunWith(BlockJUnit4ClassRunner.class)
public class TestBeanScope extends UnitTestBase{

	public TestBeanScope(){
		
		super("classpath*:spring-beanscope.xml");
		
	}
	
	@Test
	public void TestSay_Singleton(){
		
		BeanScope beanscope1=super.getBean("beanScope");
		beanscope1.say();
		beanscope1.setId(2);
		beanscope1.print();
		
		BeanScope beanscope2=super.getBean("beanScope");
		beanscope2.say();
		beanscope2.setId(3);
		beanscope2.print();
		
		beanscope1.say();
		beanscope1.print();
		
	}
	
	@Test
	public void TestSay_Prototype(){
		
		BeanScope beanscope1=super.getBean("beanScope");
		beanscope1.say();
		beanscope1.setId(2);
		beanscope1.print();
		
		BeanScope beanscope2=super.getBean("beanScope");
		beanscope2.say();
		beanscope2.setId(3);
		beanscope2.print();
		
		beanscope1.say();
		beanscope1.print();
		
	}
	
}
