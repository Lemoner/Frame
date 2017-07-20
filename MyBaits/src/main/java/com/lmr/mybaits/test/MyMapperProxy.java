package com.lmr.mybaits.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class MyMapperProxy implements InvocationHandler {

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		
		System.out.println(args.length);
		System.out.println(args[0]);
		
		List<String> list=new ArrayList<>();
		list.add("1");
		list.add("2");
		list.add("3");
		
		return list;
	}

}
