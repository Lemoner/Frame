package com.lmr.handler;

/**
 * ���δ�������
 */
public class HandlerTwo extends Handler{

	@Override
	public void HandleRequest(int count) {
		
		if(count<30){
			System.out.println("HandlerTwo deal with "+count);
		}
		else{
			successor.HandleRequest(count);
		}
		
	}

}
