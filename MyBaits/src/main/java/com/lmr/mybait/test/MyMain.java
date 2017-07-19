package com.lmr.mybait.test;

import java.util.List;

public class MyMain {

	public static void main(String[] args) {
		
		MySqlSession mySqlSession=new MySqlSession();
		MyInterface myInterface=mySqlSession.getMapper(MyInterface.class);
		
		List<String> list=myInterface.querylist("This");
		System.out.println(list.size());
	}
	
}
