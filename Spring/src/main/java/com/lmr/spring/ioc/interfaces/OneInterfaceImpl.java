package com.lmr.spring.ioc.interfaces;

public class OneInterfaceImpl implements OneInterface{

	@Override
	public String SayWord(String word) {
		// TODO Auto-generated method stub
		return "Word from interface \"OneInterface\" : "+word;
	}

}
