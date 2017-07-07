package com.lmr.mybaits.bean;

import java.util.List;

/**
 * 指令表
 */
public class Command {

	/**
	 * 主键
	 */
	private int id;
	/**
	 * 指令名字
	 */
	private String name;
	/**
	 * 指令描述
	 */
	private String description;
	/**
	 * 指令对应的回复内容集合
	 */
	private List<CommandContent> contentlist;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<CommandContent> getContentlist() {
		return contentlist;
	}
	public void setContentlist(List<CommandContent> contentlist) {
		this.contentlist = contentlist;
	}
	
	@Override
	public String toString() {
		return "Command [id=" + id + ", name=" + name + ", description=" + description + ", contentlist=" + contentlist.toString()
				+ "]";
	}
}
