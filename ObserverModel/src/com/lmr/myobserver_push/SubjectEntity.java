package com.lmr.myobserver_push;

/**
 * Ŀ��ʵ��
 */
public class SubjectEntity extends Subject {

	/**
	 * ��������
	 */
	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
		this.publishInfo();
	}

}
