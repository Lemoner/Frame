package com.lmr.seckill.dao.cache;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lmr.seckill.dao.SeckillDao;
import com.lmr.seckill.entity.Seckill;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class RedisDaoTest {

	@Autowired
	private RedisDao redisDao;
	
	@Autowired
	private SeckillDao seckillDao;
	
	@Test
	public void testGetSeckill() {
		
		long seckillId=1001;
		Seckill seckill=redisDao.getSeckill(seckillId);
		System.out.println(seckill.toString());
		
	}

	@Test
	public void testSetSeckill() {
		
		long seckillId=1001;
		Seckill seckill=seckillDao.queryById(seckillId);
		
		String result=redisDao.setSeckill(seckill);
		System.out.println(result);
		
	}

}
