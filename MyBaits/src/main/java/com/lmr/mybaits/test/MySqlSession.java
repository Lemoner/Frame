package com.lmr.mybaits.test;

import java.lang.reflect.Proxy;

public class MySqlSession {

	@SuppressWarnings("unchecked")
	public<T> T getMapper(Class<T> iclass){
		
		
		
		return (T)Proxy.newProxyInstance(iclass.getClassLoader(), new Class[]{iclass}, new MyMapperProxy());
	}
	
}
