package com.lmr.springmvc.Model;

public class LoginBean {

	private String loginid;
	private String loginpw;
	
	public LoginBean(String loginid, String loginpw) {
		super();
		this.loginid = loginid;
		this.loginpw = loginpw;
	}
	public String getLoginid() {
		return loginid;
	}
	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}
	public String getLoginpw() {
		return loginpw;
	}
	public void setLoginpw(String loginpw) {
		this.loginpw = loginpw;
	}
	
	
	
}
