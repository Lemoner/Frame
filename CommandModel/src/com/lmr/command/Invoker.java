package com.lmr.command;

/**
 * 请求者
 */
public class Invoker {

	/*
	 * 持有命令对象
	 */
	private Command command;
	
	public Invoker(Command command) {
		this.command=command;
	}
	
	/**
	 * 行动方法
	 */
	public void action(){
		command.execute();
	}
	
}
