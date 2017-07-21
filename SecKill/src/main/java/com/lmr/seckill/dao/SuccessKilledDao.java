package com.lmr.seckill.dao;

import org.apache.ibatis.annotations.Param;

import com.lmr.seckill.entity.SuccessKilled;

/**
 * 与秒杀成功明细表相关的数据库操作接口
 */
public interface SuccessKilledDao {

	/**
	 * 添加秒杀成功明细记录
	 * @param seckillId	秒杀商品库存ID
	 * @param userPhone	用户的手机号
	 * @return	如果影响行数>=1，表示更新库存的记录行数
	 */
	public int insertSuccessKilled(@Param("seckillId") long seckillId, @Param("userPhone") long userPhone);
	
	/**
	 * 根据秒杀商品的ID查询秒杀成功明细SuccessKilled对象，该对象携带了Seckill秒杀商品对象
	 * @param seckillId	秒杀商品库存ID
	 * @param userPhone	用户的手机号
	 * @return	秒杀成功明细对象
	 */
	public SuccessKilled queryByIdWithSeckill(@Param("seckillId") long seckillId, @Param("userPhone") long userPhone);
	
}
