package com.lmr.transaction;

public class AccountServiceImpl implements AccountService {

	private AccountDao accountDao;
	
	
	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	@Override
	public void transfer(String in, String out, Double money) {
		
		accountDao.inMoney(in, money);
		accountDao.outMoney(out, money);
		
	}

}
