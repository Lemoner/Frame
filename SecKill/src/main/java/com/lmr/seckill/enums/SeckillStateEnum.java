package com.lmr.seckill.enums;

/**
 * 秒杀状态枚举类
 */
public enum SeckillStateEnum {

	SUCCESS(1,"秒杀成功"),
	END(0,"秒杀结束"),
    REPEAT_KILL(-1,"重复秒杀"),
    INNER_ERROR(-2,"系统异常"),
    DATE_REWRITE(-3,"数据篡改");
	
	private int state;
	private String infor;
	
	SeckillStateEnum(int state, String infor) {
		this.state = state;
		this.infor = infor;
	}

	public int getState() {
		return state;
	}
	
	public String getInfor() {
		return infor;
	}
	
	
	
}
