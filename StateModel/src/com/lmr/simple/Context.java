package com.lmr.simple;

/**
 * ������ɫ��������
 */
public class Context {

	/**
	 * State����ʵ��
	 */
	private State state;

	public void setState(State state) {
		this.state = state;
	}
	
	/**
	 * ����State������
	 */
	public void request(){
		state.handle();
	}
	
}
