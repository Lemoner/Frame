package com.lmr.seckill.exception;

/**
 * ��ɱ��ص�����ҵ���쳣
 */
public class SeckillException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7702711314529238058L;

	public SeckillException(String message, Throwable cause) {
		super(message, cause);
	}

	public SeckillException(String message) {
		super(message);
	}

}
