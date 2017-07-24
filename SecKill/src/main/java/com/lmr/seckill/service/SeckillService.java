package com.lmr.seckill.service;

import java.util.List;

import com.lmr.seckill.dto.SeckillExecution;
import com.lmr.seckill.dto.SeckillExposer;
import com.lmr.seckill.entity.Seckill;
import com.lmr.seckill.exception.SeckillCloseException;
import com.lmr.seckill.exception.SeckillException;
import com.lmr.seckill.exception.SeckillRepeatException;

/**
 * ��ɱҵ����صĽӿ�
 */
public interface SeckillService {

	/**
	 * ������ɱ��ƷID��ȡ������ɱ��Ʒ��¼
	 * @param seckillId	��ɱ��ƷID
	 * @return	������ɱ��Ʒ����
	 */
	public Seckill getSeckillById(long seckillId);
	
	/**
	 * ����ƫ������ȡ������ɱ��Ʒ��¼
	 * @param offset	��ʼ�㣬�ӵڼ�����ʼȡ
	 * @param limit		��ȡ������
	 * @return	������ɱ��Ʒ����List
	 */
	public List<Seckill> getSeckillAll(int offset, int limit);
	
	/**
	 * ����ɱ����ʱ�����ɱ�ӿڵĵ�ַ���������ϵͳʱ�����ɱʱ��
	 * @param seckillId	��ɱ��ƷID
	 * @return	��ɱ�ӿڶ���
	 */
	public SeckillExposer exportSeckillUrl(long seckillId);
	
	/**
	 * ִ����ɱ�����������ݿ�����Ӽ�¼���п���ʧ�ܣ��п��ܳɹ�
	 * @param seckillId	��ɱ��ƷID
	 * @param userPhone	��ɱ�û����ֻ���
	 * @param md5		���ܴ�ʩ������ɱ�ӿڵĵ�ַ��md5ֵ
	 * @return	��ɱִ�н������
	 * @throws SeckillException			��ɱ��ص�����ҵ���쳣		
	 * @throws SeckillCloseException	��ɱ�ر��쳣
	 * @throws SeckillRepeatException	�ظ���ɱ�쳣
	 */
	public SeckillExecution executeSeckill(long seckillId, long userPhone, String md5) throws SeckillException, SeckillCloseException, SeckillRepeatException;
	
}
