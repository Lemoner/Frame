package com.lmr.seckill.service.impl;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lmr.seckill.dto.SeckillExecution;
import com.lmr.seckill.dto.SeckillExposer;
import com.lmr.seckill.entity.Seckill;
import com.lmr.seckill.service.SeckillService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})
public class SeckillServiceImplTest {

	@Resource
	private SeckillService seckillService;
	
	@Test
	public void testGetSeckillById() {
		
		long seckillId=1000;
		Seckill seckill=seckillService.getSeckillById(seckillId);
		System.out.println(seckill.toString());
		
	}

	@Test
	public void testGetSeckillAll() {
		
		int offset=1;
		int limit=2;
		List<Seckill> seckills=seckillService.getSeckillAll(offset, limit);
		System.out.println(seckills.size());
		for(Seckill seckill:seckills){
			System.out.println(seckill.toString());
		}
		
	}

	@Test
	public void testExportSeckillUrl() {
		
		long seckillId=1000;
		SeckillExposer seckillExposer=seckillService.exportSeckillUrl(seckillId);
		System.out.println(seckillExposer.toString());
//		SeckillExposer [exposed=true, md5=edf548ca8e0c43c96ef33e499fb2e2a6, seckillId=1000, now=0, start=0, end=0]
		
	}

	@Test
	public void testExecuteSeckill() {
		
		long seckillId=1000;
		long userPhone=15911334466L;
		String md5="edf548ca8e0c43c96ef33e499fb2e2a6";
		SeckillExecution seckillExecution=seckillService.executeSeckill(seckillId, userPhone, md5);
		System.out.println(seckillExecution.toString());
		
	}

}
