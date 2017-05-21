package com.lmr.spring.beanannotation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import com.lmr.spring.base.UnitTestBase;
import com.lmr.spring.beanannotation.base.DiverManager;
import com.lmr.spring.beanannotation.base.Store;

@RunWith(BlockJUnit4ClassRunner.class)
public class TestBeanBase extends UnitTestBase{

	public TestBeanBase() {
		super("classpath*:spring-beanannotation.xml");
	}
	
	@Test
	public void TestBean(){
		Store store=super.getBean("stringStore");
		System.out.println(store.getClass().getName());
	}
	
	@Test
	public void TestDiver(){
		DiverManager diver=super.getBean("diverManager");
	}
	
	@Test
	public void TestScope(){
		Store store=super.getBean("stringStore");
		System.out.println(store.hashCode());
		store=super.getBean("stringStore");
		System.out.println(store.hashCode());
	}
	
}
