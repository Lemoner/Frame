package com.lmr.spring.beanannotation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import com.lmr.spring.base.UnitTestBase;
import com.lmr.spring.beanannotation.injection.service.InjectionService;

@RunWith(BlockJUnit4ClassRunner.class)
public class TestBeanAutowired extends UnitTestBase{
	
	public TestBeanAutowired() {
		super("classpath:spring-beanannotation.xml");
	}
	
	@Test
	public void TestAutowired(){
		InjectionService service=super.getBean("injectionServiceImpl");
		service.save("TestAutowired");
	}

}
