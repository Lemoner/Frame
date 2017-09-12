package com.lmr.handler;

/**
 * 责任处理对象一
 */
public class HandlerOne extends Handler{

	@Override
	public void HandleRequest(int count) {
		
		if(count<10){
			System.out.println("HandlerOne deal with "+count);
		}
		else{
			successor.HandleRequest(count);
		}
		
	}

}
