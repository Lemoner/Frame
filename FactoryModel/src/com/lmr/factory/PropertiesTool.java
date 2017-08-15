package com.lmr.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 资源工具类
 */
public class PropertiesTool {

	/**
	 * 获取Properties资源文件内容，以键值对的方式存入map中
	 * @param file	Properties资源文件名
	 * @return	Properties资源文件内容的Map集合
	 */
	public static Map<String, String> getPropertiesMap(String file){
		
		Map<String, String> map = new HashMap<String, String>();
		
		Properties properties=new Properties();
		
		try {
			InputStream stream=PropertiesTool.class.getResourceAsStream(file);
			properties.load(stream);
			
			Enumeration<?> en=properties.propertyNames();
			while (en.hasMoreElements()) {
				String key = (String) en.nextElement();
				String value=properties.getProperty(key);
				map.put(key, value);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return map;
		
	}
	
}
