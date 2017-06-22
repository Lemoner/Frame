package com.lmr.transaction;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(BlockJUnit4ClassRunner.class)
public class TestAccount extends UnitTestBase{

	public TestAccount() {
		super("classpath:spring-transaction.xml");
	}
	
	@Test
	public void TestTransfer(){
		AccountService service=(AccountService)super.getBean("accountService");
		service.transfer("aaa", "bbb", 200.0);
	}
	
}
