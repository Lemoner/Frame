package com.lmr.factory;

import java.util.Map;

/**
 * 发型工厂
 */
public class HairFactory {

	/**
	 * 通过关键字获取发型实例
	 * @param key	关键字
	 * @return	HairInterface对象
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
	 * 通过类名反射获取发型实例
	 * @param className	类名
	 * @return	HairInterface对象
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
	 * 通过关键字读取资源文件获取类名来得到发型实例
	 * @param classKey	关键字
	 * @return	HairInterface对象
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
