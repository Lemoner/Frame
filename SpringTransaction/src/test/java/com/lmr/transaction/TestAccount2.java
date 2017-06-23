package com.lmr.transaction;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lmr.transaction.AccountService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring-transaction.xml")
public class TestAccount2{

	@Resource(name="accountService")
	private AccountService service;
	
	@Test
	public void TestTransfer(){
		service.transfer("aaa", "bbb", 200.0);
	}
	
}
