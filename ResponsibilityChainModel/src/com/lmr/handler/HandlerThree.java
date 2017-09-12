package com.lmr.handler;

/**
 * 责任处理对象三
 */
public class HandlerThree extends Handler{

	@Override
	public void HandleRequest(int count) {
		
		if(count<60){
			System.out.println("HandlerThree deal with "+count);
		}
		else{
			System.out.println("No Handler can deal with "+count);
		}
		
	}

}
