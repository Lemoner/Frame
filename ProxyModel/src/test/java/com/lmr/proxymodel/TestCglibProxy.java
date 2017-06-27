package com.lmr.proxymodel;

import org.junit.Test;

import com.lmr.cglibproxy.TimeCglib;
import com.lmr.cglibproxy.Train;

public class TestCglibProxy {

	@Test
	public void TestTrainMove(){
		
		TimeCglib time=new TimeCglib();
		Train train=(Train)time.getProxy(Train.class);
		train.move();
		
	}
	
	@Test
	public void TestTrainMove2(){
		
		Train train=new Train();
		
		TimeCglib time=new TimeCglib();
		Train t=(Train)time.getProxy(train);
		
		t.move();
		
	}
	
}
