package com.lmr.handler;

/**
 * ���δ��������
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
