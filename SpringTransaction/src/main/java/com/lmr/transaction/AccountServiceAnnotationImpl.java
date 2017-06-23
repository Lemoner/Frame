package com.lmr.transaction;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation=Propagation.REQUIRED)
public class AccountServiceAnnotationImpl implements AccountService{

	private AccountDao accountDao;

	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}
	
	@Override
	public void transfer(String in, String out, Double money) {
		
		accountDao.inMoney(in, money);
//		int a=1/0;
		accountDao.outMoney(out, money);

	}
	
}
