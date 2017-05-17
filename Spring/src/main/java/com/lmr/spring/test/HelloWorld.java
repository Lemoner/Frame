package com.lmr.spring.test;

public class HelloWorld {

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public void printMessage(){
		System.out.println("Your Message is : "+message);
	}
	
}
