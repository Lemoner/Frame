package com.lmr.transaction;

import org.junit.After;
import org.junit.Before;
import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.StringUtils;

public class UnitTestBase {

	private ClassPathXmlApplicationContext context;
	
	private String springxmlpath;
	
	public UnitTestBase() {
		// TODO Auto-generated constructor stub
	}
	
	public UnitTestBase(String springxmlpath){
		this.springxmlpath=springxmlpath;
	}
	
	@Before
	public void Before(){
		
//		if(StringUtils.isEmpty(springxmlpath)){
//			springxmlpath = "classpath*:spring-*.xml";
//		}
		
		try {
			context=new ClassPathXmlApplicationContext(springxmlpath);
			context.start();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	@After
	public void after(){
		context.destroy();
	}
	
	@SuppressWarnings("unchecked")
	protected <T extends Object> T getBean(String beanId) {
		try {
			return (T)context.getBean(beanId);
		} catch (BeansException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	protected <T extends Object> T getBean(Class<T> clazz) {
		try {
			return context.getBean(clazz);
		} catch (BeansException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	
}
