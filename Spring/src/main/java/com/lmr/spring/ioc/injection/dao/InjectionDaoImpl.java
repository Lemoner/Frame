package com.lmr.spring.ioc.injection.dao;

public class InjectionDaoImpl implements InjectionDao{

	@Override
	public void save(String arg) {
		// TODO Auto-generated method stub
		
		//模拟数据库保存操作
		System.out.println("Dao层保存数据: "+arg);
		
	}

}
