package com.lmr.myobserver_pull;

import java.util.ArrayList;
import java.util.List;

/**
 * ����Ŀ���࣬�������ӣ�ɾ���۲��ߣ�������Ϣ
 */
abstract public class Subject {

	/**
	 * �۲��߼���
	 */
	private List<Observer> observers=new ArrayList<>();
	
	/**
	 * ������Ϣ
	 * @param content	��Ϣ����
	 */
	public void publishInfo(String content){
		for(Observer observer:observers){
			observer.updateInfo(content);
		}
	}
	
	/**
	 * ��ӹ۲���
	 * @param observer	�۲��߶���
	 */
	public void add(Observer observer){
		observers.add(observer);
	}
	
	/**
	 * ɾ���۲���
	 * @param observer	�۲��߶���
	 */
	public void delect(Observer observer){
		observers.remove(observer);
	}
	
}
