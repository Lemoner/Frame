package com.lmr.transaction;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import com.lmr.transaction.AccountService;

@RunWith(BlockJUnit4ClassRunner.class)
public class TestAccountAnnotation extends UnitTestBase{

	public TestAccountAnnotation() {
		super("classpath:spring-transaction-annotation.xml");
	}
	
	@Test
	public void TestTransfer(){
		AccountService service=(AccountService)super.getBean("accountService");
		service.transfer("aaa", "bbb", 200.0);
	}
	
}
