package com.lmr.transaction;

public interface AccountService {

	/**
	 * @param in	
	 * @param out
	 * @param money
	 */
	public void transfer(String in, String out, Double money);
	
}
