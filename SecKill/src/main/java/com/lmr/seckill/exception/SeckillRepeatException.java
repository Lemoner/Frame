package com.lmr.seckill.exception;

/**
 * 重复秒杀异常，是一个运行期异常
 * Mysql只支持运行期异常的回滚操作
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
