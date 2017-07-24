package com.lmr.seckill.exception;

/**
 * 秒杀相关的所有业务异常
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
