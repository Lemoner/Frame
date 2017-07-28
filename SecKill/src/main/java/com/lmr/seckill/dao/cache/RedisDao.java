package com.lmr.seckill.dao.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtobufIOUtil;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.runtime.RuntimeSchema;
import com.lmr.seckill.entity.Seckill;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * redis缓存操作dao层
 */
public class RedisDao {
	
	/**
	 * 日志对象
	 */
	private Logger logger=LoggerFactory.getLogger(this.getClass());

	/**
	 * Redis连接池
	 */
	private final JedisPool jedisPool;
	
	/**
	 * 序列化文件的schema模式
	 */
	private RuntimeSchema<Seckill> schema=RuntimeSchema.createFrom(Seckill.class);
	
	/**
	 * RedisDao构造函数
	 * @param ip	redis服务器的ip地址
	 * @param port	redis服务器的端口号
	 */
	public RedisDao(String ip, int port){
		jedisPool=new JedisPool(ip, port);
	}
	
	/**
	 * 根据秒杀商品ID获取信息
	 * @param seckillId	秒杀商品ID
	 * @return	秒杀商品对象
	 */
	public Seckill getSeckill(long seckillId){
		
		Seckill seckill = null;
		
		try {
			Jedis jedis= jedisPool.getResource();
			try {
				String key="seckillId:"+seckillId;
				//取数据
				byte[] bs=jedis.get(key.getBytes());
				
				if(bs!=null){
					//进行反序列化
					seckill=schema.newMessage();
					ProtostuffIOUtil.mergeFrom(bs, seckill, schema);
					return seckill;
				}
			} finally {
				jedis.close();
			}
		} catch (Exception e) {
			logger.debug(e.getMessage(), e);
		}
		
		return seckill;
		
	}
	
	/**
	 * 向Redis缓存中存放秒杀商品信息
	 * @param seckill	秒杀商品信息对象
	 * @return	是否存放成功，OK为成功
	 */
	public String setSeckill(Seckill seckill){
		String result = null;
		try {
			Jedis jedis=jedisPool.getResource();
			try {
				String key="seckillId:"+seckill.getSeckillId();
				//序列化
				byte[] bs=ProtostuffIOUtil.toByteArray(seckill, schema, LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
				
				int timeout = 60 * 60;//1小时
				//存数据
				result=jedis.setex(key.getBytes(), timeout, bs);
				return result;
			} finally {
				jedis.close();
			}
		} catch (Exception e) {
			logger.debug(e.getMessage(), e);
		}
		return result;
	}
	
}
