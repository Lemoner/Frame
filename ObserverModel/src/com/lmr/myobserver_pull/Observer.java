package com.lmr.myobserver_pull;

/**
 * 观察者接口
 */
public interface Observer {

	/**
	 * 更新信息
	 * @param content	信息内容
	 */
	public void updateInfo(String content);
	
}
