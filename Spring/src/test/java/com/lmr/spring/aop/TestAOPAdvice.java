package com.lmr.spring.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import com.lmr.spring.aop.advice.AdviceService;
import com.lmr.spring.aop.advice.Filter;
import com.lmr.spring.base.UnitTestBase;

@RunWith(BlockJUnit4ClassRunner.class)
public class TestAOPAdvice extends UnitTestBase{

	public TestAOPAdvice() {
		super("classpath:spring-aop-advice.xml");
	}
	
	@Test
	public void TestAdvice(){
		AdviceService service=super.getBean("adviceService");
		service.say();
//		service.say();
	}
	
	@Test
	public void TestAroundParameter(){
		AdviceService service=super.getBean("adviceService");
		service.sayParameter("root", 9999);
	}
	
	@Test
	public void TestDeclareparents(){
		Filter filter=(Filter)super.getBean("adviceService");
		filter.control();
	}
	
}
