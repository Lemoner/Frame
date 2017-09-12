package com.lmr.handler;

/**
 * ���������󹤳�
 */
public class HandlerFactory {

	/**
	 * ��װ��������������ײ��Handler����
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
