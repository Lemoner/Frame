package com.lmr.spring.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class BeanAware implements BeanNameAware,ApplicationContextAware{

	private String beanname;
	private ApplicationContext context;
	
	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		// TODO Auto-generated method stub
		this.context=arg0;
		System.out.println("BeanAware setApplicationContext : "+context.getBean(beanname).hashCode());
	}

	@Override
	public void setBeanName(String name) {
		// TODO Auto-generated method stub
		this.beanname=name;
		System.out.println("BeanAware name : "+beanname);
	}
	
}
