package com.lmr.myobserver_pull;

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
		this.publishInfo(content);
	}

}
