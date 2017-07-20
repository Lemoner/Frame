package com.lmr.mybaits.service;

import java.util.List;
import java.util.Random;

import com.lmr.mybaits.bean.Command;
import com.lmr.mybaits.bean.CommandContent;
import com.lmr.mybaits.bean.Message;
import com.lmr.mybaits.dao.CommandDao;
import com.lmr.mybaits.dao.MessageDao;
import com.lmr.mybaits.util.Iconst;
import com.lmr.mybaits.util.Page;

/**
 * 查询相关的业务功能
 */
public class QueryService {
	
	/**
	 * 查询Message表的全部记录
	 * 
	 * @param command	命令
	 * @param description	简要描述
	 * @return Message的List集合
	 */
	public List<Message> queryMessageList(String command, String description){
		
		MessageDao messageDao=new MessageDao();
		return messageDao.listMessage(command, description);
		
	}
	
	/**
	 * 查询指定页数的Message表的记录
	 * 
	 * @param page 	页数
	 * @param description 	简要描述
	 * @param command	命令
	 * 
	 * @return Message的List集合
	 */
	public List<Message> queryMessageListByPage(String command, String description, Page page){
		
		MessageDao messageDao=new MessageDao();
		
		Message message=new Message();
		message.setCommand(command);
		message.setDescription(description);
		
		page.setTotalNumber(messageDao.queryMessageSize());
		page.count();
		
		System.out.println(page.toString());
		
		return messageDao.queryMessageListByPage(message, page);
		
	}
	
	/**
	 * 通过指令查找记录
	 * 
	 * @param command	指令
	 * @return	指令对应的回复内容
	 */
	public String queryMessageByCommand(String command){
		
		MessageDao messageDao=new MessageDao();
//		Message message=messageDao.queryMessageByCommand(command);
		List<Message> messagelist=messageDao.listMessage(command, null);
		if(messagelist.size()>0){
			return messagelist.get(0).getContent();
		}
		else{
			return Iconst.NO_MATCHING_CONTENT;
		}
	}
	
	/**
	 * 通过指令查找记录
	 * 
	 * @param name	指令
	 * @param description	描述
	 * @return	随机返回一条该指令对应的回复内容
	 */
	public String queryCommandList(String name,String description){
		
		CommandDao commandDao=new CommandDao();
		List<Command> commandlist=commandDao.queryCommandList(name, description);
		
		if(commandlist.size()>0){
			List<CommandContent> contentlist=commandlist.get(0).getContentlist();
			Random rand=new Random();
			return contentlist.get(rand.nextInt(contentlist.size())).getContent();
		}
		else{
			return Iconst.NO_MATCHING_CONTENT;
		}
		
	}
	
}
