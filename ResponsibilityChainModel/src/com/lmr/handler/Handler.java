package com.lmr.handler;

/**
 * ��������
 */
public abstract class Handler {

	/**
	 * ��̵����δ������
	 */
	protected Handler successor;
	
	public void setSuccessor(Handler successor) {
		this.successor = successor;
	}

	/**
	 * ��������
	 * �������������ȥ����Ҳ����ת������̶���ȥ����
	 * @param count	����
	 */
	public abstract void HandleRequest(int count);
	
}
