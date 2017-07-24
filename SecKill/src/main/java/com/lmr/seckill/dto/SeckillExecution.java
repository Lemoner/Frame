package com.lmr.seckill.dto;

import com.lmr.seckill.entity.SuccessKilled;
import com.lmr.seckill.enums.SeckillStateEnum;

/**
 * ��ɱִ��֮��Ľ�����Ƿ���ɱ�ɹ�
 */
public class SeckillExecution {

	/**
	 * ��ɱ��ƷID
	 */
	private long seckillId;
	
	/**
	 * ��ɱִ�н����״̬
	 */
	private int state;
	
	/**
	 * ״̬�����ı�ʶ
	 */
	private String stateInfor;
	
	/**
	 * ��ɱ�ɹ�֮�󷵻ص���ɱ�ɹ��Ķ���
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
