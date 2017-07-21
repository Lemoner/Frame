package com.lmr.seckill.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lmr.seckill.entity.Seckill;

/**
 * 与秒杀库存表相关的数据库操作接口
 */
public interface SeckillDao {

	/**
	 * 减库存操作
	 * @param seckillId	秒杀商品库存ID
	 * @param killTime	秒杀时间
	 * @return	如果影响行数>=1，表示更新库存的记录行数
	 */
	public int reduceNumber(@Param("seckillId") long seckillId, @Param("killTime") Date killTime);
	
	/**
	 * 根据ID查找秒杀商品信息
	 * @param seckillId	秒杀商品库存ID
	 * @return	秒杀商品对象
	 */
	public Seckill queryById(@Param("seckillId") long seckillId);
	
	/**
	 * 根据页数偏移量查找秒杀商品列表
	 * @param offset	起始数	
	 * @param limit		数量
	 * @return	秒杀商品列表
	 */
	public List<Seckill> queryAll(@Param("offset") int offset, @Param("limit") int limit);
	
}
