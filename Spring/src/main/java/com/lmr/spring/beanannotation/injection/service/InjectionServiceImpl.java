package com.lmr.spring.beanannotation.injection.service;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.lmr.spring.beanannotation.injection.dao.InjectionDao;

@Service
public class InjectionServiceImpl implements InjectionService{

//	@Autowired()
//	@Qualifier("injectionDaoImplOne")
	@Inject
	@Named("injectionDaoImplTwo")
	private InjectionDao injectionDao;
	
	//设值注入
//	@Autowired()
//	public void setInjectionDao(@Qualifier("injectionDaoImplOne")InjectionDao injectionDao) {
//		this.injectionDao = injectionDao;
//	}
	
	//构造器注入
//	@Autowired()
//	public InjectionServiceImpl(InjectionDao injectionDao) {
//		// TODO Auto-generated constructor stub
//		this.injectionDao=injectionDao;
//	}

	@Override
	public void save(String arg) {
		// TODO Auto-generated method stub
		
		//模拟业务操作
		System.out.println("Service层接收数据: "+arg);
		
		injectionDao.save(arg);
		
	}

}
