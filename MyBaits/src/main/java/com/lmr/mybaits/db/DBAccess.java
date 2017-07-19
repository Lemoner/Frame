package com.lmr.mybaits.db;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.lmr.mybaits.bean.Message;

/**
 * 数据库连接类
 */
public class DBAccess {
	
	public void JDBCAccess(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mybaits_message","root","123456");
			
			StringBuilder sql = new StringBuilder("select ID a,COMMAND,DESCRIPTION,CONTENT from MESSAGE where 1=1");
			PreparedStatement statement = conn.prepareStatement(sql.toString());
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				Message message = new Message();
				message.setId(rs.getInt("a"));
				message.setCommand(rs.getString("COMMAND"));
				message.setDescription(rs.getString("DESCRIPTION"));
				message.setContent(rs.getString("CONTENT"));
				System.out.println(message.toString());
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * MyBaits方式连接
	 * @return SqlSession会话
	 * @throws IOException
	 */
	public SqlSession mybaitsAccess() throws IOException{
		
		//通过配置文件获取数据库连接信息
		Reader reader=Resources.getResourceAsReader("Configuration.xml");
		//通过配置信息构建一个SqlSessionFactory
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(reader);
		//通过SqlSessionFactory打开一个数据库会话
		SqlSession sqlSession=factory.openSession();
		
		return sqlSession;
		
	}
	
}
