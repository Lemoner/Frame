package com.lmr.mybaits.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.lmr.mybaits.bean.Command;
import com.lmr.mybaits.bean.ICommand;
import com.lmr.mybaits.db.DBAccess;

/**
 * ��command����ص����ݿ����
 */
public class CommandDao {

	/**
	 * ����ָ��ȥ����ȫ���ظ�����
	 * 
	 * @param name	ָ����
	 * @param description	ָ������
	 * @return	ָ���ظ����ݵļ���
	 */
	public List<Command> queryCommandList(String name,String description){
		
		List<Command> commandlist=new ArrayList<>();
		
		DBAccess dbAccess=new DBAccess();
		SqlSession sqlSession=null;
		
		try{
			
			sqlSession=dbAccess.mybaitsAccess();
			
			Command command=new Command();
			command.setName(name);
			command.setDescription(description);
			
//			commandlist=sqlSession.selectList("Command.queryCommandList", command);
			
			ICommand iCommand=sqlSession.getMapper(ICommand.class);
			commandlist=iCommand.queryCommandList(command);
			
			for(Command com:commandlist){
				System.out.println(com.toString());
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(sqlSession!=null){
				sqlSession.close();
			}
		}
		
		return commandlist;
		
	}
	
}
