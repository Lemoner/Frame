package com.lmr.seckill.dao;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lmr.seckill.entity.SuccessKilled;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SuccessKilledDaoTest {

	@Resource
	private SuccessKilledDao successKilledDao;
	
	@Test
	public void testInsertSuccessKilled() {

		long seckillId=1000;
		long userPhone=13855886699L;
		int number=successKilledDao.insertSuccessKilled(seckillId, userPhone);
		System.out.println(number);
	
	}

	@Test
	public void testQueryByIdWithSeckill() {
		
		long seckillId=1000;
		long userPhone=13855886699L;
		SuccessKilled successKilled=successKilledDao.queryByIdWithSeckill(seckillId, userPhone);
		System.out.println(successKilled.toString());
		
	}

}
