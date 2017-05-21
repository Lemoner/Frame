package com.lmr.spring.beanannotation.base;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

@Configuration
@ImportResource(value = { "classpath:/resourceconfig.xml" })
public class StoreConfig {
	
	@Value("${jdbc.username}")
	private String username;
	
	@Value("${jdbc.password}")
	private String password;
	
	@Value("${jdbc.url}")
	private String url;

	@Bean(name="stringStore")
	@Scope(value="prototype",proxyMode=ScopedProxyMode.TARGET_CLASS)
	public Store getStringStore(){
		return new StringStore();
	}
	
	@Bean(name="diverManager")
	public DiverManager getDiverManager(){
		return new DiverManager(username, password, url);
	}
	
}
