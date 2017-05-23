package com.lmr.spring.beanannotation.jsr;

import javax.inject.Named;

import org.springframework.stereotype.Repository;

@Repository
public class JsrDao {

	public void save(String word){
		System.out.println("JsrDao : "+word);
	}
	
}
