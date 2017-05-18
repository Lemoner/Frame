package com.lmr.spring.beanannotation;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Component("bean")
@Scope("prototype")
public class BeanAnnotation {

	public void say(String word){
		System.out.println("BeanAnnotation : "+word);
	}
	
	public void sayhash(String word){
		System.out.println("BeanAnnotation : "+word+" "+this.hashCode());
	}
	
}
