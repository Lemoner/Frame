package com.lmr.transaction;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(BlockJUnit4ClassRunner.class)
public class TestAccountProxy extends UnitTestBase{

	public TestAccountProxy() {
		
		super("classpath:spring-transaction-proxy.xml");
		
	}
	
	@Test
	public void TestTransfer(){
		AccountService service=super.getBean("accountServiceProxy");
		service.transfer("aaa", "bbb", 200.0);
	}
	
}
