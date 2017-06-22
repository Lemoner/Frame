package com.lmr.transaction;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {

//	@Override
//	public void outMoney(String out, Double money) {
//
//		this.getJdbcTemplate().update("update account set money = money - ? where name = ?", money, out);
//		
//	}
//
//	@Override
//	public void inMoney(String in, Double money) {
//		
//		this.getJdbcTemplate().update("update account set money = money + ? where name = ?", money, in);
//		
//	}
	
	/**
	 * @param out	:转出账号
	 * @param money	:转账金额
	 */
	@Override
	public void outMoney(String out, Double money) {
		String sql = "update account set money = money-? where name = ?";
		this.getJdbcTemplate().update(sql, money, out);
	}

	/**
	 * @param in	:转入账号
	 * @param money	:转账金额
	 */
	@Override
	public void inMoney(String in, Double money) {
		String sql = "update account set money = money+? where name = ?";
		this.getJdbcTemplate().update(sql,money,in);
	}

}
