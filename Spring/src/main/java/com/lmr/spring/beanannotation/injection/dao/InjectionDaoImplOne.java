package com.lmr.spring.beanannotation.injection.dao;

import org.springframework.stereotype.Repository;

@Repository
public class InjectionDaoImplOne implements InjectionDao{

	@Override
	public void save(String arg) {
		// TODO Auto-generated method stub
		
		//模拟数据库保存操作
		System.out.println("InjectionDaoImplOne Dao层保存数据: "+arg);
				
	}

}
