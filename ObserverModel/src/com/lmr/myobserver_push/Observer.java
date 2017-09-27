package com.lmr.myobserver_push;

/**
 * 观察者接口
 */
public interface Observer {

	/**
	 * 更新信息
	 * @param subject	目标对象
	 */
	public void updateInfo(Subject subject);
	
}
