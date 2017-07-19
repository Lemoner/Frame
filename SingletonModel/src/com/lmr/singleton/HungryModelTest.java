package com.lmr.singleton;

public class HungryModelTest {

	public static void main(String[] args) {
		
		HungryModel hungryModel1=HungryModel.getHungryModel();
		HungryModel hungryModel2=HungryModel.getHungryModel();
		
		if(hungryModel1==hungryModel2){
			System.out.println("两者为同一对象");
		} 
		else{
			System.out.println("两者不是同一对象");
		}
		
		System.out.println(hungryModel1.toString());
		System.out.println(hungryModel2.toString());
		
		hungryModel2.setId(999);
		
		System.out.println(hungryModel1.toString());
		System.out.println(hungryModel2.toString());
		
	}
}
