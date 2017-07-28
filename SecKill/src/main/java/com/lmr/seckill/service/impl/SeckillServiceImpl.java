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
 * ��ɱҵ����ص�ʵ��
 */
@Service
public class SeckillServiceImpl implements SeckillService{

	/**
	 * ��־����
	 */
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	/**
	 * ����ɱ������ص����ݿ��������
	 */
	@Autowired
	private SeckillDao seckillDao;
	
	/**
	 * Redis�����������
	 */
	@Autowired
	private RedisDao redisDao; 
	
	/**
	 * ����ɱ�ɹ���ϸ����ص����ݿ��������
	 */
	@Autowired
	private SuccessKilledDao successKilledDao;
	
	/**
	 * ����һ�������ַ���(��ɱ�ӿ�)��salt��Ϊ�˱����û��³����ǵ�md5ֵ��ֵ�������Խ����Խ��
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
		
		//���ȴ�Redis������ȡ����
		seckill=redisDao.getSeckill(seckillId);
		if(seckill==null){
			seckill= seckillDao.queryById(seckillId);
			//�鲻������ɱ��Ʒ��¼
			if(seckill==null){
				return new SeckillExposer(false, seckillId);
			}
			else{
				redisDao.setSeckill(seckill);
			}
		}
		
//		Seckill seckill= seckillDao.queryById(seckillId);
//		
//		//�鲻������ɱ��Ʒ��¼
//		if(seckill==null){
//			return new SeckillExposer(false, seckillId);
//		}
		
		Date nowTime=new Date();
		//��ɱδ����
		if(nowTime.getTime()<seckill.getStartTime().getTime()||nowTime.getTime()>seckill.getEndTime().getTime()){
			return new SeckillExposer(false, seckillId, nowTime.getTime(), seckill.getStartTime().getTime(), seckill.getEndTime().getTime());
		}
		
		//��ɱ������������ɱ��Ʒ��id����ɱ��ַ���ܵ�md5
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
			//���б������쳣ת��Ϊ�������쳣
            throw new SeckillException("seckill inner error :"+e.getMessage());
		}
		
	}
	
	/**
	 * ����MD5ֵ������ΪseckillId+"/"+slat
	 * @param seckillId	��ɱ��ƷID
	 * @return	MD5ֵ
	 */
	private String getMD5(long seckillId){
		
		String content=seckillId+"/"+slat;
		return DigestUtils.md5DigestAsHex(content.getBytes());
		
	}
	
}
