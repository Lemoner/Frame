package com.lmr.adaptermodel.combine;

/**
 * ÊÊÅäÆ÷
 */
public class Adapter implements Target{

	private Adaptee adaptee;
	
	public Adapter(Adaptee adaptee){
		this.adaptee=adaptee;
	}

	@Override
	public void OperationOne() {
		System.out.println("To Adapter");
		adaptee.Operation();
	}

	@Override
	public void OperationTwo() {
		
	}
	
	
	
}
