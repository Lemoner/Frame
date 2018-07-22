package com.lmr.simple;

/**
 * 环境角色，上下文
 */
public class Context {

	/**
	 * State对象实例
	 */
	private State state;

	public void setState(State state) {
		this.state = state;
	}
	
	/**
	 * 请求State处理方法
	 */
	public void request(){
		state.handle();
	}
	
}
