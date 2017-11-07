package com.lmr.adaptermodel.extend;

/**
 * ÊÊÅäÆ÷
 */
public class Adapter extends Adaptee implements Target{

	@Override
	public void OperationOne() {
		System.out.println("To Adapter");
		super.Operation();
	}

	@Override
	public void OperationTwo() {
		
	}
	
	
	
}
