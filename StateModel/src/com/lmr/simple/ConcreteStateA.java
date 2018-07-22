package com.lmr.simple;

/**
 * ¾ßÌå×´Ì¬A
 */
public class ConcreteStateA implements State {

	@Override
	public void handle() {
		System.out.println("ConcreteStateA is handle");
	}

}
