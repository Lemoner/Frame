package com.lmr.seckill.dao;

import com.lmr.seckill.entity.SuccessKilled;

/**
 * ����ɱ�ɹ���ϸ����ص����ݿ�����ӿ�
 */
public interface SuccessKilledDao {

	/**
	 * �����ɱ�ɹ���ϸ��¼
	 * @param seckillId	��ɱ��Ʒ���ID
	 * @param userPhone	�û����ֻ���
	 * @return	���Ӱ������>=1����ʾ���¿��ļ�¼����
	 */
	public int insertSuccessKilled(long seckillId, long userPhone);
	
	/**
	 * ������ɱ��Ʒ��ID��ѯ��ɱ�ɹ���ϸSuccessKilled���󣬸ö���Я����Seckill��ɱ��Ʒ����
	 * @param seckillId	��ɱ��Ʒ���ID
	 * @param userPhone	�û����ֻ���
	 * @return	��ɱ�ɹ���ϸ����
	 */
	public SuccessKilled queryByIdWithSeckill(long seckillId, long userPhone);
	
}
