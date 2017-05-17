package com.lmr.spring.ioc.injection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import com.lmr.spring.base.UnitTestBase;
import com.lmr.spring.ioc.injection.service.InjectionService;

@RunWith(BlockJUnit4ClassRunner.class)
public class TestInjection extends UnitTestBase{

	public TestInjection() {
		// TODO Auto-generated constructor stub
		
		super("classpath*:spring-injection.xml");
		
	}
	
	@Test
	public void TestSetter(){
		
		InjectionService service=super.getBean("injectionService");
		service.save("name=123");
		
	}
	
	@Test
	public void TestConstructor(){
		
		InjectionService service=super.getBean("injectionService");
		service.save("name=123");
		
	}
	
	
}
