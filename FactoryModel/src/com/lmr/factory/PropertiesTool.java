package com.lmr.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertiesTool {

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
