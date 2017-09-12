package com.lmr.handler;

/**
 * 责任链对象工厂
 */
public class HandlerFactory {

	/**
	 * 组装责任链，返回最底层的Handler对象
	 */
	public static Handler CreateHandlerFactory(){
		
		Handler handler1=new HandlerOne();
		Handler handler2=new HandlerTwo();
		Handler handler3=new HandlerThree();
		
		handler1.setSuccessor(handler2);
		handler2.setSuccessor(handler3);
		
		return handler1;
		
	}
	
}
