package com.lmr.mybaits.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.lmr.mybaits.bean.Message;
import com.lmr.mybaits.db.DBAccess;

/**
 * 和message表相关的数据库操作
 */
public class MessageDao {

	/**
	 * 向数据库中查询message的记录
	 * 
	 * @param command
	 *            命令
	 * @param description
	 *            简要描述
	 * @return Message的List集合
	 */
	public List<Message> listMessage(String command, String description) {

		List<Message> messagelist = new ArrayList<>();

		DBAccess dbAccess=new DBAccess();
		SqlSession sqlSession=null;
		try {
			sqlSession=dbAccess.mybaitsAccess();
			
			Message message=new Message();
			message.setCommand(command);
			message.setDescription(description);
			
			messagelist=sqlSession.selectList("Message.queryMessageList", message);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(sqlSession!=null){
				sqlSession.close();
			}
		}
		

		return messagelist;

	}
	
	/**
	 * 
	 * 从数据库中删除一条message的记录
	 * 
	 * @param id	message的id
	 */
	public void deleteMessage(int id){

		DBAccess dbAccess=new DBAccess();
		SqlSession sqlSession=null;
		try {
			sqlSession=dbAccess.mybaitsAccess();
			
			sqlSession.delete("Message.deleteMessage", id);
			sqlSession.commit();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(sqlSession!=null){
				sqlSession.close();
			}
		}
	}
	
	/**
	 * 从数据库中删除多条message的记录
	 * 
	 * @param idlist	要删除的message的id集合
	 */
	public void deleteMessageList(List<Integer> idlist){
		
		DBAccess dbAccess=new DBAccess();
		SqlSession sqlSession=null;
		try {
			sqlSession=dbAccess.mybaitsAccess();
			
			sqlSession.delete("Message.deleteMessageList", idlist);
			sqlSession.commit();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(sqlSession!=null){
				sqlSession.close();
			}
		}
		
	}
	
	/**
	 * 通过指令查找message
	 * 
	 * @param command	指令
	 * @return	指令对应的消息
	 */
	public Message queryMessageByCommand(String command){
		
		DBAccess dbAccess=new DBAccess();
		SqlSession sqlSession=null;
		Message message=null;
		try{
			
			sqlSession=dbAccess.mybaitsAccess();
			message=sqlSession.selectOne("Message.queryMessageByCommand", command);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(sqlSession!=null){
				sqlSession.close();
			}
		}
		
		return message;
	}

	// public List<Message> ListMessage(String command, String description){
	//
	// List<Message> messagelist=new ArrayList<>();
	//
	// try {
	//
	// Class.forName("com.mysql.jdbc.Driver");
	// Connection conn =
	// DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mybaits_message","root","123456");
	//
	// StringBuilder sql = new StringBuilder("select ID
	// a,COMMAND,DESCRIPTION,CONTENT from MESSAGE where 1=1 ");
	//
	// if(command!=null&&!command.equals("")){
	// sql.append("and COMMAND='"+command+"' ");
	// }
	// if(description!=null&&!description.equals("")){
	// sql.append("and DESCRIPTION LIKE '%"+description+"%' ");
	// }
	//
	// System.out.println(sql.toString());
	//
	// PreparedStatement statement = conn.prepareStatement(sql.toString());
	//
	// ResultSet rs = statement.executeQuery();
	//
	// while(rs.next()) {
	// Message message = new Message();
	// message.setId(rs.getInt("a"));
	// message.setCommand(rs.getString("COMMAND"));
	// message.setDescription(rs.getString("DESCRIPTION"));
	// message.setContent(rs.getString("CONTENT"));
	// messagelist.add(message);
	// }
	//
	// conn.close();
	// statement.close();
	// rs.close();
	//
	// } catch (ClassNotFoundException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// return messagelist;
	//
	// }

}
