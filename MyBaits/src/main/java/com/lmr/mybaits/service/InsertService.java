package com.lmr.mybaits.service;

import com.lmr.mybaits.bean.Message;
import com.lmr.mybaits.dao.MessageDao;

/**
 * �����ص�ҵ����
 */
public class InsertService {

	/**
	 * ��ӵ���Message��¼
	 * 
	 * @param message	�����Ϣ
	 */
	public void insertMessage(Message message){
		
		MessageDao messageDao=new MessageDao();
		
		message.setId(messageDao.queryMessageMaxId()+1);
		
		messageDao.insertMessage(message);
		
	}
	
}
