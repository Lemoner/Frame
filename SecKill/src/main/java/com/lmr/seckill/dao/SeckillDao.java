package com.lmr.seckill.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

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
	public int reduceNumber(@Param("seckillId") long seckillId, @Param("killTime") Date killTime);
	
	/**
	 * ����ID������ɱ��Ʒ��Ϣ
	 * @param seckillId	��ɱ��Ʒ���ID
	 * @return	��ɱ��Ʒ����
	 */
	public Seckill queryById(@Param("seckillId") long seckillId);
	
	/**
	 * ����ҳ��ƫ����������ɱ��Ʒ�б�
	 * @param offset	��ʼ��	
	 * @param limit		����
	 * @return	��ɱ��Ʒ�б�
	 */
	public List<Seckill> queryAll(@Param("offset") int offset, @Param("limit") int limit);
	
}
