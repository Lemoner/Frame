package com.lmr.command;

/**
 * ������
 */
public class Invoker {

	/*
	 * �����������
	 */
	private Command command;
	
	public Invoker(Command command) {
		this.command=command;
	}
	
	/**
	 * �ж�����
	 */
	public void action(){
		command.execute();
	}
	
}
