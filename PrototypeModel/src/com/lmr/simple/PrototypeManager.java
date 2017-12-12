package com.lmr.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * 原型管理器
 */
public class PrototypeManager {

	/**
	 * 原型管理map映射表：编号-原型实例
	 */
	private static Map<String, Prototype> map=new HashMap<>();
	
	/**
	 * 私有化构造方法
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
