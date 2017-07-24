package com.lmr.seckill.dto;

import com.lmr.seckill.entity.SuccessKilled;
import com.lmr.seckill.enums.SeckillStateEnum;

/**
 * 秒杀执行之后的结果：是否秒杀成功
 */
public class SeckillExecution {

	/**
	 * 秒杀商品ID
	 */
	private long seckillId;
	
	/**
	 * 秒杀执行结果的状态
	 */
	private int state;
	
	/**
	 * 状态的明文标识
	 */
	private String stateInfor;
	
	/**
	 * 秒杀成功之后返回的秒杀成功的对象
	 */
	private SuccessKilled successKilled;

	public SeckillExecution(long seckillId, SeckillStateEnum seckillStateEnum, SuccessKilled successKilled) {
		this.seckillId = seckillId;
		this.state = seckillStateEnum.getState();
		this.stateInfor = seckillStateEnum.getInfor();
		this.successKilled = successKilled;
	}

	public SeckillExecution(long seckillId, SeckillStateEnum seckillStateEnum) {
		this.seckillId = seckillId;
		this.state = seckillStateEnum.getState();
		this.stateInfor = seckillStateEnum.getInfor();
	}

	public long getSeckillId() {
		return seckillId;
	}

	public void setSeckillId(long seckillId) {
		this.seckillId = seckillId;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getStateInfor() {
		return stateInfor;
	}

	public void setStateInfor(String stateInfor) {
		this.stateInfor = stateInfor;
	}

	public SuccessKilled getSuccessKilled() {
		return successKilled;
	}

	public void setSuccessKilled(SuccessKilled successKilled) {
		this.successKilled = successKilled;
	}

	@Override
	public String toString() {
		return "SeckillExecution [seckillId=" + seckillId + ", state=" + state + ", stateInfor=" + stateInfor
				+ ", successKilled=" + successKilled + "]";
	}
	
}
