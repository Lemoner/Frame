package com.lmr.jdkobserver;

import java.util.Observable;

/**
 * Ŀ��ʵ��
 */
public class SubjectEntity extends Observable {

	/**
	 * ��Ϣ����
	 */
	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.setChanged();
		this.content = content;
		//Push�Ʒ�ʽ
//		this.notifyObservers();
		//Pull����ʽ
		this.notifyObservers(content);
	}

}
