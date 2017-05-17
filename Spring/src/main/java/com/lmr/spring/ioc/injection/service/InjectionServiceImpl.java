package com.lmr.spring.ioc.injection.service;

import com.lmr.spring.ioc.injection.dao.InjectionDao;

public class InjectionServiceImpl implements InjectionService{

	private InjectionDao injectionDao;
	
	//设值注入
//	public void setInjectionDao(InjectionDao injectionDao) {
//		this.injectionDao = injectionDao;
//	}
	
	//构造器注入
	public InjectionServiceImpl(InjectionDao injectionDao) {
		// TODO Auto-generated constructor stub
		this.injectionDao=injectionDao;
	}

	@Override
	public void save(String arg) {
		// TODO Auto-generated method stub
		
		//模拟业务操作
		System.out.println("Service层接收数据: "+arg);
		
		injectionDao.save(arg);
		
	}

}
