package com.lmr.transaction;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(BlockJUnit4ClassRunner.class)
public class TestAccountAspectJ extends UnitTestBase{

	public TestAccountAspectJ() {
		super("classpath:spring-transaction-aspectj.xml");
	}
	
	@Test
	public void TestTranfer(){
		AccountService service=(AccountService)super.getBean("accountService");
		service.transfer("aaa", "bbb", 200.0);
	}
	
}
