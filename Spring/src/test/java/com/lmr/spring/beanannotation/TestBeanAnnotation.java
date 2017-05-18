package com.lmr.spring.beanannotation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import com.lmr.spring.base.UnitTestBase;

@RunWith(BlockJUnit4ClassRunner.class)
public class TestBeanAnnotation extends UnitTestBase{

	public TestBeanAnnotation() {
		super("classpath*:spring-beanannotation.xml");
	}
	
	@Test
	public void TestSay(){
		BeanAnnotation beanAnnotation=super.getBean("beanAnnotation");
		beanAnnotation.say("hello @ Annotation !");
	}
	
	@Test
	public void TestScope(){
		BeanAnnotation beanAnnotation1=super.getBean("beanAnnotation");
		beanAnnotation1.sayhash("hello beanAnnotation1");
		BeanAnnotation beanAnnotation2=super.getBean("beanAnnotation");
		beanAnnotation2.sayhash("hello beanAnnotation2");
	}
	
}
