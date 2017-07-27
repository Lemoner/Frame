package com.lmr.seckill.dto;

/**
 * ��ɱ������������
 * �����е�ajax���󷵻����ͣ�ȫ����װ��json����
 *
 * @param <T>	����ɹ��Ľ������
 */
public class SeckillResult<T> {

	/**
	 * �Ƿ�����ɹ�
	 */
	private Boolean flag;
	/**
	 * ����ɹ��Ľ������
	 */
	private T data;
	/**
	 * ����ʧ�ܵ�ԭ��
	 */
	private String error;
	
	/**
	 * �ɹ�����
	 * @param flag	true
	 * @param data	�������
	 */
	public SeckillResult(Boolean flag, T data) {
		this.flag = flag;
		this.data = data;
	}
	
	/**
	 * ʧ������
	 * @param flag	false
	 * @param error	ʧ��ԭ��
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
