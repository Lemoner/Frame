package com.lmr.mybaits.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.lmr.mybaits.bean.Command;
import com.lmr.mybaits.bean.ICommand;
import com.lmr.mybaits.db.DBAccess;

/**
 * 和command表相关的数据库操作
 */
public class CommandDao {

	/**
	 * 根据指令去查找全部回复内容
	 * 
	 * @param name	指令名
	 * @param description	指令描述
	 * @return	指令及其回复内容的集合
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
