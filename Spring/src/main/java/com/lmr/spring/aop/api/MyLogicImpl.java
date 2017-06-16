package com.lmr.spring.aop.api;

public class MyLogicImpl implements MyLogic{

	@Override
	public String save() {
		// TODO Auto-generated method stub
		System.out.println("MyLogicImpl save");
		return "MyLogicImpl save";
	}

}
