package com.lmr.spring.bean;

public class BeanAutowireService {

	private BeanAutowireDao beanAutowireDao;

	public void setBeanAutowireDao(BeanAutowireDao beanAutowireDao) {
		System.out.println("setBeanAutowireDao");
		this.beanAutowireDao = beanAutowireDao;
	}
	
//	public BeanAutowireService(BeanAutowireDao beanAutowireDao) {
//		System.out.println("Constructor");
//		this.beanAutowireDao = beanAutowireDao;
//	}
	
	public void say(String word){
		
		System.out.println("BeanAutowireService : "+word);
		beanAutowireDao.say(word);
		
	}
	
}
