package com.lmr.client;

import java.util.Random;

import com.lmr.handler.Handler;
import com.lmr.handler.HandlerFactory;

public class TestClient {

	public static void main(String[] args) {
		
		Handler handler=HandlerFactory.CreateHandlerFactory();
		
		for(int i=1;i<=10;i++){
			Random rand=new Random();
			int count=rand.nextInt(100);
			System.out.print(i+" : ");
			handler.HandleRequest(count);
		}
		
	}
	
}
