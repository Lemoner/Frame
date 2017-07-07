package com.lmr.mybaits.service;

import java.util.ArrayList;
import java.util.List;

import com.lmr.mybaits.dao.MessageDao;

/**
 * ��ɾ����ص�ҵ����
 */
public class DeleteService {

	/**
	 * 
	 * ɾ������message
	 * 
	 * @param id	Ҫɾ����message��id
	 */
	public void deleteMessage(String id){
		
		if(id!=null&&!id.trim().equals("")){
			MessageDao messageDao=new MessageDao();
			messageDao.deleteMessage(Integer.parseInt(id));
		}
		
	}
	
	/**
	 * ɾ������message
	 * 
	 * @param ids	Ҫɾ����message���ϵ�id
	 */
	public void deleteMessageList(String[] ids){
		
		List<Integer> idlist=new ArrayList<>();
		for(String id : ids){
			idlist.add(Integer.parseInt(id));
		}
		MessageDao messageDao=new MessageDao();
		messageDao.deleteMessageList(idlist);
		
	}
	
}
