package com.lmr.myobserver_pull;

/**
 * 目标实体
 */
public class SubjectEntity extends Subject {

	/**
	 * 推送内容
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
