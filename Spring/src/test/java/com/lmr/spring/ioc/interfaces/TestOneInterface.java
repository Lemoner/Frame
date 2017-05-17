package com.lmr.spring.ioc.interfaces;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lmr.spring.base.UnitTestBase;

@RunWith(BlockJUnit4ClassRunner.class)//默认的测试类执行器
//@RunWith(value = SpringJUnit4ClassRunner.class)//让测试运行于spring测试环境
public class TestOneInterface extends UnitTestBase{

	public TestOneInterface(){
		
		super("classpath*:spring-ioc.xml");
		
	}
	
	@Test
	public void testSayWord(){
		
		OneInterface oif=super.getBean("oneInterface");
		System.out.println(oif.SayWord("hello spring ioc"));
		
	}
	
	@Test
	public void T(){
		System.out.println(1==1);
	}
	
}
