package com.lmr.spring.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import com.lmr.spring.aop.aspectj.MyBiz;
import com.lmr.spring.base.UnitTestBase;

@RunWith(BlockJUnit4ClassRunner.class)
public class TestAOPAspectJ extends UnitTestBase{

	public TestAOPAspectJ() {
		super("classpath:spring-aop-aspectj.xml");
	}
	
	@Test
	public void TestSave(){
		MyBiz biz=super.getBean("myBiz");
		biz.save("123456");
	}
	
}
