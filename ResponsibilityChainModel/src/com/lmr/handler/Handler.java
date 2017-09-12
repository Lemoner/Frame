package com.lmr.handler;

/**
 * 抽象处理者
 */
public abstract class Handler {

	/**
	 * 后继的责任处理对象
	 */
	protected Handler successor;
	
	public void setSuccessor(Handler successor) {
		this.successor = successor;
	}

	/**
	 * 处理请求
	 * 该请求可以自身去处理，也可以转发给后继对象去处理
	 * @param count	数量
	 */
	public abstract void HandleRequest(int count);
	
}
