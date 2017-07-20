package com.lmr.seckill.entity;

import java.util.Date;

/**
 * ��ɱ����
 */
public class Seckill {

	/**
	 * ��Ʒ���ID
	 */
	private long seckillId;
	/**
	 * ��Ʒ����
	 */
	private String name;
	/**
	 * �������
	 */
	private int number;
	/**
	 * ����ʱ��
	 */
	private Date createTime;
	/**
	 * ��ɱ��ʼʱ��
	 */
	private Date startTime;
	/**
	 * ��ɱ����ʱ��
	 */
	private Date endTime;

	public long getSeckillId() {
		return seckillId;
	}

	public void setSeckillId(long seckillId) {
		this.seckillId = seckillId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "Seckill [seckillId=" + seckillId + ", name=" + name + ", number=" + number + ", createTime="
				+ createTime + ", startTime=" + startTime + ", endTime=" + endTime + "]";
	}

}
