package com.lmr.mybaits.bean;

/**
 * ָ���Ӧ�Ļظ����ݱ�
 */
public class CommandContent {

	/**
	 * ����
	 */
	private int id;
	/**
	 * �ظ�����
	 */
	private String content;
	/**
	 * ��Ӧ��ָ��id
	 */
	private int commandid;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getCommandid() {
		return commandid;
	}
	public void setCommandid(int commandid) {
		this.commandid = commandid;
	}
	
	@Override
	public String toString() {
		return "CommandContent [id=" + id + ", content=" + content + ", commandid=" + commandid + "]";
	}
	
}
