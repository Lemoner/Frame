package com.lmr.factory;

public class FactoryTest {

	public static void main(String[] args) {
		
		FactoryTestByInterface();
		FactoryTestByKey();
		FactoryTestByClass();
		FactoryTestByClassKey();
		
	}

	private static void FactoryTestByClassKey() {
		
		String key;
		
		key="LeftHair";
		HairInterface lefthair=HairFactory.getHairByClassKey(key);
		lefthair.show();
		
		key="RightHair";
		HairInterface righthair=HairFactory.getHairByClassKey(key);
		righthair.show();
	}

	private static void FactoryTestByClass() {
		
		String className;
		
		className="com.lmr.factory.LeftHair";
		HairInterface lefthair=HairFactory.getHairByClass(className);
		lefthair.show();
		
		className="com.lmr.factory.RightHair";
		HairInterface righthair=HairFactory.getHairByClass(className);
		righthair.show();
		
	}

	private static void FactoryTestByKey() {
		
		String key;
		
		key="LeftHair";
		HairInterface lefthair=HairFactory.getHairByKey(key);
		lefthair.show();
		
		key="RightHair";
		HairInterface righthair=HairFactory.getHairByKey(key);
		righthair.show();
		
	}

	private static void FactoryTestByInterface() {
		
		HairInterface lefthair=new LeftHair();
		lefthair.show();
		
		HairInterface righthair=new RightHair();
		righthair.show();
		
	}
	
}
