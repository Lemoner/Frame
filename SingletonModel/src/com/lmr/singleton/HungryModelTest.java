package com.lmr.singleton;

public class HungryModelTest {

	public static void main(String[] args) {
		
		HungryModel hungryModel1=HungryModel.getHungryModel();
		HungryModel hungryModel2=HungryModel.getHungryModel();
		
		if(hungryModel1==hungryModel2){
			System.out.println("����Ϊͬһ����");
		} 
		else{
			System.out.println("���߲���ͬһ����");
		}
		
		System.out.println(hungryModel1.toString());
		System.out.println(hungryModel2.toString());
		
		hungryModel2.setId(999);
		
		System.out.println(hungryModel1.toString());
		System.out.println(hungryModel2.toString());
		
	}
}
