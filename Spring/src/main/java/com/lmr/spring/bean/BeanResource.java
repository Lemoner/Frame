package com.lmr.spring.bean;

import java.io.FileInputStream;
import java.io.IOException;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.Resource;

public class BeanResource implements ApplicationContextAware{

	private ApplicationContext applicationContext;
	
	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		// TODO Auto-generated method stub
		this.applicationContext=arg0;
	}
	
	public void resource() throws IOException{
		Resource resource=applicationContext.getResource("classpath:config.xml");
//		Resource resource=applicationContext.getResource("file:D:\\coding\\codeworksace\\Spring\\src\\main\\resources\\config.xml");
//		Resource resource=applicationContext.getResource("url:http://docs.spring.io/spring-boot/docs/2.0.0.BUILD-SNAPSHOT/reference/htmlsingle/");
//		Resource resource=applicationContext.getResource("config.xml");
		
		
		System.out.println(resource.getFilename());
		System.out.println(resource.contentLength());
		FileInputStream input=new FileInputStream(resource.getFile());
		byte[] bytes=new byte[1024];
		while(input.read(bytes)!=-1){
			System.out.println(new String(bytes));
		}
		input.close();
	}

}
