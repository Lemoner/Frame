package com.lmr.seckill.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import com.lmr.seckill.dao.SeckillDao;
import com.lmr.seckill.dao.SuccessKilledDao;
import com.lmr.seckill.dao.cache.RedisDao;
import com.lmr.seckill.dto.SeckillExecution;
import com.lmr.seckill.dto.SeckillExposer;
import com.lmr.seckill.entity.Seckill;
import com.lmr.seckill.entity.SuccessKilled;
import com.lmr.seckill.enums.SeckillStateEnum;
import com.lmr.seckill.exception.SeckillCloseException;
import com.lmr.seckill.exception.SeckillException;
import com.lmr.seckill.exception.SeckillRepeatException;
import com.lmr.seckill.service.SeckillService;

/**
 * 秒杀业务相关的实现
 */
@Service
public class SeckillServiceImpl implements SeckillService{

	/**
	 * 日志对象
	 */
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	/**
	 * 与秒杀库存表相关的数据库操作对象
	 */
	@Autowired
	private SeckillDao seckillDao;
	
	/**
	 * Redis缓存操作对象
	 */
	@Autowired
	private RedisDao redisDao; 
	
	/**
	 * 与秒杀成功明细表相关的数据库操作对象
	 */
	@Autowired
	private SuccessKilledDao successKilledDao;
	
	/**
	 * 加入一个混淆字符串(秒杀接口)的salt，为了避免用户猜出我们的md5值，值任意给，越复杂越好
	 */
	private final String slat="&^&@BSDH&*dsjf238";
	
	@Override
	public Seckill getSeckillById(long seckillId) {
		return seckillDao.queryById(seckillId);
	}

	@Override
	public List<Seckill> getSeckillAll(int offset, int limit) {
		return seckillDao.queryAll(offset, limit);
	}

	@Override
	public SeckillExposer exportSeckillUrl(long seckillId) {

		Seckill seckill=null;
		
		//首先从Redis缓存中取数据
		seckill=redisDao.getSeckill(seckillId);
		if(seckill==null){
			seckill= seckillDao.queryById(seckillId);
			//查不到该秒杀物品记录
			if(seckill==null){
				return new SeckillExposer(false, seckillId);
			}
			else{
				redisDao.setSeckill(seckill);
			}
		}
		
//		Seckill seckill= seckillDao.queryById(seckillId);
//		
//		//查不到该秒杀物品记录
//		if(seckill==null){
//			return new SeckillExposer(false, seckillId);
//		}
		
		Date nowTime=new Date();
		//秒杀未开启
		if(nowTime.getTime()<seckill.getStartTime().getTime()||nowTime.getTime()>seckill.getEndTime().getTime()){
			return new SeckillExposer(false, seckillId, nowTime.getTime(), seckill.getStartTime().getTime(), seckill.getEndTime().getTime());
		}
		
		//秒杀开启，返回秒杀商品的id、秒杀地址加密的md5
		return new SeckillExposer(true, getMD5(seckillId), seckillId);
	}

	@Override
	@Transactional
	public SeckillExecution executeSeckill(long seckillId, long userPhone, String md5)
			throws SeckillException, SeckillCloseException, SeckillRepeatException {

		try {
			
			if(md5==null||!md5.equals(getMD5(seckillId))){
				throw new SeckillException("seckill data rewrite");
			}
			
			Date nowTime=new Date();
			int insertnumber=successKilledDao.insertSuccessKilled(seckillId, userPhone);
			if(insertnumber<=0){
				throw new SeckillRepeatException("seckill repeated");
			}
			else{
				int reducenumber=seckillDao.reduceNumber(seckillId, nowTime);
				if(reducenumber<=0){
					throw new SeckillCloseException("seckill is closed");
				}
				else{
					SuccessKilled successKilled=successKilledDao.queryByIdWithSeckill(seckillId, userPhone);
					return new SeckillExecution(seckillId, SeckillStateEnum.SUCCESS, successKilled);
				}
			}
			
		} catch (SeckillRepeatException e1) {
			throw e1;
		} catch (SeckillCloseException e2) {
			throw e2;
		} catch (SeckillException e) {
			logger.debug(e.getMessage(), e);
			//所有编译期异常转化为运行期异常
            throw new SeckillException("seckill inner error :"+e.getMessage());
		}
		
	}
	
	/**
	 * 生成MD5值，内容为seckillId+"/"+slat
	 * @param seckillId	秒杀商品ID
	 * @return	MD5值
	 */
	private String getMD5(long seckillId){
		
		String content=seckillId+"/"+slat;
		return DigestUtils.md5DigestAsHex(content.getBytes());
		
	}
	
}
