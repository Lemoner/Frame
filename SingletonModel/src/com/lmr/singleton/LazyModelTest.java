package com.lmr.singleton;

public class LazyModelTest {
	
	public static void main(String[] args) {
		
		LazyModel lazyModel1=LazyModel.getLazyModel();
		LazyModel lazyModel2=LazyModel.getLazyModel();
		
		if(lazyModel1==lazyModel2){
			System.out.println("两者为同一对象");
		}
		else{
			System.out.println("两者不是同一对象");
		} 
		
		System.out.println("lazyModel1 : "+lazyModel1.toString());
		System.out.println("lazyModel2 : "+lazyModel2.toString());
		
		lazyModel2.setId(666); 
		
		System.out.println("lazyModel1 : "+lazyModel1.toString());
		System.out.println("lazyModel2 : "+lazyModel2.toString());

	}
}
