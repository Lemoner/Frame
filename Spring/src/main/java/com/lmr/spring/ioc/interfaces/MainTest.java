package com.lmr.spring.ioc.interfaces;

public class MainTest {

	public static void main(String[] args) {
		
		OneInterface oif=new OneInterfaceImpl();
		
		System.out.println(oif.SayWord("hello ioc"));
		
	}
	
}
