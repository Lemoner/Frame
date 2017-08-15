package com.lmr.factory;

import java.util.Map;

/**
 * ���͹���
 */
public class HairFactory {

	/**
	 * ͨ���ؼ��ֻ�ȡ����ʵ��
	 * @param key	�ؼ���
	 * @return	HairInterface����
	 */
	public static HairInterface getHairByKey(String key){
		
		HairInterface hair = null;
		if("LeftHair".equals(key)){
			hair=new LeftHair();
		}
		else if("RightHair".equals(key)){
			hair=new RightHair();
		}
		return hair;
		
	}
	
	/**
	 * ͨ�����������ȡ����ʵ��
	 * @param className	����
	 * @return	HairInterface����
	 */
	public static HairInterface getHairByClass(String className){
		
		HairInterface hair = null;
		
		try {
			Class<?> hairclass=Class.forName(className);
			hair=(HairInterface) hairclass.newInstance();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return hair;
		
	}
	
	/**
	 * ͨ���ؼ��ֶ�ȡ��Դ�ļ���ȡ�������õ�����ʵ��
	 * @param classKey	�ؼ���
	 * @return	HairInterface����
	 */
	public static HairInterface getHairByClassKey(String classKey){
		
		HairInterface hair = null;
		
		Map<String, String> map=PropertiesTool.getPropertiesMap("HairTypeClass.properties");
		String className=null;
		className=map.get(classKey);
		
		try {
			Class<?> hairclass=Class.forName(className);
			hair=(HairInterface) hairclass.newInstance();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return hair;
		
	}
	
}
