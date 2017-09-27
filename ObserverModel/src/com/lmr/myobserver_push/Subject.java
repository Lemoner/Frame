package com.lmr.myobserver_push;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象目标类，用于增加，删除观察者，发布信息
 */
abstract public class Subject {

	/**
	 * 观察者集合
	 */
	private List<Observer> observers=new ArrayList<>();
	
	/**
	 * 发布信息
	 */
	public void publishInfo(){
		for(Observer observer:observers){
			observer.updateInfo(this);
		}
	}
	
	/**
	 * 添加观察者
	 * @param observer	观察者对象
	 */
	public void add(Observer observer){
		observers.add(observer);
	}
	
	/**
	 * 删除观察者
	 * @param observer	观察者对象
	 */
	public void delect(Observer observer){
		observers.remove(observer);
	}
	
}
