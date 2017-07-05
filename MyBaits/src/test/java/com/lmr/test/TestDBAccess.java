package com.lmr.test;

import org.junit.Test;

import com.lmr.mybaits.db.DBAccess;

public class TestDBAccess {

	@Test
	public void TestJDBC(){
		DBAccess db=new DBAccess();
		db.JDBCAccess();
	}
	
}
