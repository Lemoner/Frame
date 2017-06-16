package com.lmr.spring.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import com.lmr.spring.aop.api.MyLogic;
import com.lmr.spring.base.UnitTestBase;

@RunWith(BlockJUnit4ClassRunner.class)
public class TestAOPApi extends UnitTestBase{

	public TestAOPApi() {
		super("classpath:spring-aop-api.xml");
	}
	
	@Test
	public void TestLogicSave(){
		MyLogic logic=super.getBean("myLogicImpl");
		logic.save();
	}
	
}
