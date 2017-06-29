package com.lmr.springmvc.Model;

public class ScoreBean {

	private String sname;
	private String sid;
	private String sgrade;
	private int chinese;
	private int math;
	private int english;
	
	public ScoreBean() {
		super();
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getSgrade() {
		return sgrade;
	}

	public void setSgrade(String sgrade) {
		this.sgrade = sgrade;
	}

	public int getChinese() {
		return chinese;
	}

	public void setChinese(int chinese) {
		this.chinese = chinese;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getEnglish() {
		return english;
	}

	public void setEnglish(int english) {
		this.english = english;
	}

	@Override
	public String toString() {
		return "ScoreBean [sname=" + sname + ", sid=" + sid + ", sgrade=" + sgrade + ", chinese=" + chinese + ", math="
				+ math + ", english=" + english + "]";
	}

}
