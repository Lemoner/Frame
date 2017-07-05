package com.lmr.mybaits.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lmr.mybaits.bean.Message;


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
}
