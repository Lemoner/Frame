package com.lmr.jdkobserver;

import java.util.Observable;

/**
 * 目标实体
 */
public class SubjectEntity extends Observable {

	/**
	 * 信息内容
	 */
	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.setChanged();
		this.content = content;
		//Push推方式
//		this.notifyObservers();
		//Pull拉方式
		this.notifyObservers(content);
	}

}
