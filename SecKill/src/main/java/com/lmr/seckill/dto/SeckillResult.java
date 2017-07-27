package com.lmr.seckill.dto;

/**
 * 秒杀操作请求结果类
 * 将所有的ajax请求返回类型，全部封装成json数据
 *
 * @param <T>	请求成功的结果类型
 */
public class SeckillResult<T> {

	/**
	 * 是否请求成功
	 */
	private Boolean flag;
	/**
	 * 请求成功的结果数据
	 */
	private T data;
	/**
	 * 请求失败的原因
	 */
	private String error;
	
	/**
	 * 成功请求
	 * @param flag	true
	 * @param data	结果数据
	 */
	public SeckillResult(Boolean flag, T data) {
		this.flag = flag;
		this.data = data;
	}
	
	/**
	 * 失败请求
	 * @param flag	false
	 * @param error	失败原因
	 */
	public SeckillResult(Boolean flag, String error) {
		this.flag = flag;
		this.error = error;
	}

	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	
}
