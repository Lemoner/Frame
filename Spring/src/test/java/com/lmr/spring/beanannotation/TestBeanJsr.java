package com.lmr.spring.beanannotation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import com.lmr.spring.base.UnitTestBase;
import com.lmr.spring.beanannotation.jsr.JsrService;

@RunWith(BlockJUnit4ClassRunner.class)
public class TestBeanJsr extends UnitTestBase{

	public TestBeanJsr() {
		super("classpath:spring-beanannotation.xml");
	}
	
	@Test
	public void TestJsrResource(){
		JsrService service=super.getBean("jsrService");
		service.save("hello jsr !");
	}
	
}
