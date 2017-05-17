package com.lmr.spring.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class BeanLifeCycle implements InitializingBean,DisposableBean{

	//配置全局默认初始化、销毁方法
	public void defaultInit(){
		System.out.println("Bean Default Init");
	}
	
	public void defaultDestory(){
		System.out.println("Bean Default Destory");
	}
	
	//实现InitializingBean、DisposableBean接口
	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Bean Init");
	}
	
	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Bean Destroy");
	}
	
	//配置init-method、destroy-method
	public void Start(){
		System.out.println("Bean Start");
	}
	
	public void Stop(){
		System.out.println("Bean Stop");
	}

}
