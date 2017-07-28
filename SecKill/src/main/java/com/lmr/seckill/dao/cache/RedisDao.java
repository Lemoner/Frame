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
 * redis�������dao��
 */
public class RedisDao {
	
	/**
	 * ��־����
	 */
	private Logger logger=LoggerFactory.getLogger(this.getClass());

	/**
	 * Redis���ӳ�
	 */
	private final JedisPool jedisPool;
	
	/**
	 * ���л��ļ���schemaģʽ
	 */
	private RuntimeSchema<Seckill> schema=RuntimeSchema.createFrom(Seckill.class);
	
	/**
	 * RedisDao���캯��
	 * @param ip	redis��������ip��ַ
	 * @param port	redis�������Ķ˿ں�
	 */
	public RedisDao(String ip, int port){
		jedisPool=new JedisPool(ip, port);
	}
	
	/**
	 * ������ɱ��ƷID��ȡ��Ϣ
	 * @param seckillId	��ɱ��ƷID
	 * @return	��ɱ��Ʒ����
	 */
	public Seckill getSeckill(long seckillId){
		
		Seckill seckill = null;
		
		try {
			Jedis jedis= jedisPool.getResource();
			try {
				String key="seckillId:"+seckillId;
				//ȡ����
				byte[] bs=jedis.get(key.getBytes());
				
				if(bs!=null){
					//���з����л�
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
	 * ��Redis�����д����ɱ��Ʒ��Ϣ
	 * @param seckill	��ɱ��Ʒ��Ϣ����
	 * @return	�Ƿ��ųɹ���OKΪ�ɹ�
	 */
	public String setSeckill(Seckill seckill){
		String result = null;
		try {
			Jedis jedis=jedisPool.getResource();
			try {
				String key="seckillId:"+seckill.getSeckillId();
				//���л�
				byte[] bs=ProtostuffIOUtil.toByteArray(seckill, schema, LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
				
				int timeout = 60 * 60;//1Сʱ
				//������
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
