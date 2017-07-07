package com.lmr.mybaits.service;

import java.util.ArrayList;
import java.util.List;

import com.lmr.mybaits.dao.MessageDao;

/**
 * 与删除相关的业务处理
 */
public class DeleteService {

	/**
	 * 
	 * 删除单条message
	 * 
	 * @param id	要删除的message的id
	 */
	public void deleteMessage(String id){
		
		if(id!=null&&!id.trim().equals("")){
			MessageDao messageDao=new MessageDao();
			messageDao.deleteMessage(Integer.parseInt(id));
		}
		
	}
	
	/**
	 * 删除多条message
	 * 
	 * @param ids	要删除的message集合的id
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
