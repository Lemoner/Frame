package com.lmr.mybaits.bean;

/**
 * 指令对应的回复内容表
 */
public class CommandContent {

	/**
	 * 主键
	 */
	private int id;
	/**
	 * 回复内容
	 */
	private String content;
	/**
	 * 对应的指令id
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
