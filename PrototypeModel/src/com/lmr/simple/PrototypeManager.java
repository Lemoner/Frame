package com.lmr.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * ԭ�͹�����
 */
public class PrototypeManager {

	/**
	 * ԭ�͹���mapӳ������-ԭ��ʵ��
	 */
	private static Map<String, Prototype> map=new HashMap<>();
	
	/**
	 * ˽�л����췽��
	 */
	private PrototypeManager(){
		
	}
	
	public synchronized static void addPrototype(String key, Prototype value){
		map.put(key, value);
	}
	
	public synchronized static Prototype getPrototype(String key){
		return map.get(key);
	}
	
	public synchronized static void removePrototype(String key){
		map.remove(key);
	}
	
}
