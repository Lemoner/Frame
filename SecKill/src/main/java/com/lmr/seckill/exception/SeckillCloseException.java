package com.lmr.seckill.exception;

/**
 * ��ɱ�ر��쳣������ɱ����ʱ�û���Ҫ������ɱ�ͻ��������쳣
 */
public class SeckillCloseException extends SeckillException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5560626974659900161L;

	public SeckillCloseException(String message) {
		super(message);
	}

	public SeckillCloseException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
