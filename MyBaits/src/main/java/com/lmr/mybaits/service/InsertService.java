package com.lmr.mybaits.service;

import com.lmr.mybaits.bean.Message;
import com.lmr.mybaits.dao.MessageDao;

/**
 * 添加相关的业务功能
 */
public class InsertService {

	/**
	 * 添加单条Message记录
	 * 
	 * @param message	添加信息
	 */
	public void insertMessage(Message message){
		
		MessageDao messageDao=new MessageDao();
		
		message.setId(messageDao.queryMessageMaxId()+1);
		
		messageDao.insertMessage(message);
		
	}
	
}
