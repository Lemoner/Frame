package com.lmr.spring.beanannotation.jsr;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JsrService {

//	@Resource
//	@Autowired
	@Inject
	private JsrDao jsrDao;
	
//	@Resource
	public void setJsrDao(@Named("jsrDao")JsrDao jsrDao) {
		this.jsrDao = jsrDao;
	}

	public void save(String word){
		System.out.println("JsrService : "+word);
		jsrDao.save(word);
	}
	
	@PostConstruct
	public void init(){
		System.out.println("JsrService init !");
	}
	
	@PreDestroy
	public void destory(){
		System.out.println("JsrService destory !");
	}
	
}
