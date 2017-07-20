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
 * ��ѯ��ص�ҵ����
 */
public class QueryService {
	
	/**
	 * ��ѯMessage���ȫ����¼
	 * 
	 * @param command	����
	 * @param description	��Ҫ����
	 * @return Message��List����
	 */
	public List<Message> queryMessageList(String command, String description){
		
		MessageDao messageDao=new MessageDao();
		return messageDao.listMessage(command, description);
		
	}
	
	/**
	 * ��ѯָ��ҳ����Message��ļ�¼
	 * 
	 * @param page 	ҳ��
	 * @param description 	��Ҫ����
	 * @param command	����
	 * 
	 * @return Message��List����
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
	 * ͨ��ָ����Ҽ�¼
	 * 
	 * @param command	ָ��
	 * @return	ָ���Ӧ�Ļظ�����
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
	 * ͨ��ָ����Ҽ�¼
	 * 
	 * @param name	ָ��
	 * @param description	����
	 * @return	�������һ����ָ���Ӧ�Ļظ�����
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
