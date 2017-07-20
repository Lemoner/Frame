package com.lmr.seckill.dao;

import java.util.Date;
import java.util.List;

import com.lmr.seckill.entity.Seckill;

/**
 * ����ɱ������ص����ݿ�����ӿ�
 */
public interface SeckillDao {

	/**
	 * ��������
	 * @param seckillId	��ɱ��Ʒ���ID
	 * @param killTime	��ɱʱ��
	 * @return	���Ӱ������>=1����ʾ���¿��ļ�¼����
	 */
	public int reduceNumber(long seckillId, Date killTime);
	
	/**
	 * ����ID������ɱ��Ʒ��Ϣ
	 * @param seckillId	��ɱ��Ʒ���ID
	 * @return	��ɱ��Ʒ����
	 */
	public Seckill queryById(long seckillId);
	
	/**
	 * ����ҳ��ƫ����������ɱ��Ʒ�б�
	 * @param offset	��ʼ��	
	 * @param limit		����
	 * @return	��ɱ��Ʒ�б�
	 */
	public List<Seckill> queryAll(int offset, int limit);
	
}
