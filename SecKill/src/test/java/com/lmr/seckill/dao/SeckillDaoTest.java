package com.lmr.seckill.dao;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.DigestUtils;

import com.lmr.seckill.entity.Seckill;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SeckillDaoTest {

	@Resource
	private SeckillDao seckillDao;
	
	@Test
	public void testReduceNumber() {
		
		long seckillId=1000;
		Date killTime=new Date();
		
		int number=seckillDao.reduceNumber(seckillId, killTime);
		System.out.println(number);
		
	}

	@Test 
	public void testQueryById() {
		
		long seckillId=1000;
		Seckill seckill=seckillDao.queryById(seckillId);
		System.out.println(seckill.toString());
		
	}

	@Test
	public void testQueryAll() {
		
		List<Seckill> seckills=seckillDao.queryAll(0, 100);
		System.out.println(seckills.size());
		for(Seckill seckill:seckills){
			System.out.println(seckill.toString());
		}
		
	}

}
