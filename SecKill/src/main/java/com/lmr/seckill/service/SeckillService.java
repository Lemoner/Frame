package com.lmr.seckill.service;

import java.util.List;

import com.lmr.seckill.dto.SeckillExecution;
import com.lmr.seckill.dto.SeckillExposer;
import com.lmr.seckill.entity.Seckill;
import com.lmr.seckill.exception.SeckillCloseException;
import com.lmr.seckill.exception.SeckillException;
import com.lmr.seckill.exception.SeckillRepeatException;

/**
 * 秒杀业务相关的接口
 */
public interface SeckillService {

	/**
	 * 根据秒杀物品ID获取单条秒杀物品记录
	 * @param seckillId	秒杀物品ID
	 * @return	单条秒杀物品对象
	 */
	public Seckill getSeckillById(long seckillId);
	
	/**
	 * 根据偏移量获取多条秒杀物品记录
	 * @param offset	起始点，从第几条开始取
	 * @param limit		共取多少条
	 * @return	多条秒杀物品对象List
	 */
	public List<Seckill> getSeckillAll(int offset, int limit);
	
	/**
	 * 在秒杀开启时输出秒杀接口的地址，否则输出系统时间和秒杀时间
	 * @param seckillId	秒杀物品ID
	 * @return	秒杀接口对象
	 */
	public SeckillExposer exportSeckillUrl(long seckillId);
	
	/**
	 * 执行秒杀操作，向数据库中添加记录，有可能失败，有可能成功
	 * @param seckillId	秒杀物品ID
	 * @param userPhone	秒杀用户的手机号
	 * @param md5		加密措施，该秒杀接口的地址的md5值
	 * @return	秒杀执行结果对象
	 * @throws SeckillException			秒杀相关的所有业务异常		
	 * @throws SeckillCloseException	秒杀关闭异常
	 * @throws SeckillRepeatException	重复秒杀异常
	 */
	public SeckillExecution executeSeckill(long seckillId, long userPhone, String md5) throws SeckillException, SeckillCloseException, SeckillRepeatException;
	
}
