package com.lmr.seckill.exception;

/**
 * �ظ���ɱ�쳣����һ���������쳣
 * Mysqlֻ֧���������쳣�Ļع�����
 */
public class SeckillRepeatException extends SeckillException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4967395304600986573L;

	public SeckillRepeatException(String message, Throwable cause) {
		super(message, cause);
	}

	public SeckillRepeatException(String message) {
		super(message);
	}

}
