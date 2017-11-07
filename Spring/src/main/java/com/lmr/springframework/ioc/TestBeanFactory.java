package com.lmr.springframework.ioc;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

public class TestBeanFactory{

	/**
	 * 编程式使用IoC容器
	 */
	public void TestOne(){
		
		//创建IoC配置文件的抽象资源，其包含BeanDefinition的定义信息
		ClassPathResource res=new ClassPathResource("springframework-beans.xml");
		//创建一个BeanFactory
		DefaultListableBeanFactory factory=new DefaultListableBeanFactory();
		//创建一个载入BeanDefinition的读取器，这里使用XmlBeanDefinitionReader来载入XML文件形式的BeanDefinition，通过一个回调配置给BeanFactory
		XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(factory);
		//从定义好的资源位置读入配置信息
		reader.loadBeanDefinitions(res);
		
		People people1=(People) factory.getBean("people");
		System.out.println(people1.toString());
		
		People people2=(People) factory.getBean("people");
		System.out.println(people2.toString());
		
		people2.setAge(99);
		
		System.out.println("people1 "+people1.toString());
		System.out.println("people2 "+people2.toString());
		
	}
	
	public static void main(String[] args) {
		
		TestBeanFactory beanFactory=new TestBeanFactory();
		
		beanFactory.TestOne();
	}
	
}
