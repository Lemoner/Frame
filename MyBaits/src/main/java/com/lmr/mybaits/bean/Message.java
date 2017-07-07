package com.lmr.mybaits.bean;

/**
 * 对应的数据库中的message表
 */
public class Message {

	/**
	 * 主键
	 */
	private int id;
	/**
	 * 指令
	 */
	private String command;
	/**
	 * 简要描述
	 */
	private String description;
	/**
	 * 回复内容
	 */
	private String content;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		return "Message [id=" + id + ", command=" + command + ", description=" + description + ", content=" + content
				+ "]";
	}
	
}
