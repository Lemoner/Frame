package com.lmr.myproxy;
public class $Proxy0 implements com.lmr.proxymodel.MoveAble{
	private com.lmr.proxymodel.MoveAble ma;
	public $Proxy0(com.lmr.proxymodel.MoveAble ma) {
		super();
		this.ma = ma;
	}
	@Override
	public void move() {
		System.out.println("汽车开始行驶...");
		long starttime = System.currentTimeMillis();
		ma.move();
		long endtime = System.currentTimeMillis();
		System.out.println("汽车结束行驶...  行驶时间: " + (endtime - starttime) + " 毫秒");
	}}