package com.lmr.spring.beanannotation;

import com.lmr.spring.beanannotation.staticService.Block;
import com.lmr.spring.beanannotation.staticService.TestConfig;
import com.lmr.spring.beanannotation.staticService.TestUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import com.lmr.spring.base.UnitTestBase;
import com.lmr.spring.beanannotation.injection.service.InjectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class TestBeanAutowired extends UnitTestBase{

	@Autowired
	TestUtils testUtils;
	
	public TestBeanAutowired() {
		super("classpath:spring-beanannotation.xml");
	}
	
	@Test
	public void TestAutowired(){
		InjectionService service=super.getBean("injectionServiceImpl");
		service.save("TestAutowired");
	}

	@Test
	public void TestCallUtil(){
//		ApplicationContext context = new AnnotationConfigApplicationContext(TestConfig.class);
//		TestUtils.CallUtil();

//		((Block)context.getBean("block")).callMethod();

		if(testUtils==null){
			System.out.println("*_*");
		}
		testUtils.CallBlock();
	}

}
