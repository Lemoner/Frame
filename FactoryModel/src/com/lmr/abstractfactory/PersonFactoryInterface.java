package com.lmr.abstractfactory;

/**
 * ������װ�����ӿ�
 */
public interface PersonFactoryInterface {

	/**
	 * ��ȡŮ����װ
	 * @return	GirlInterface����
	 */
	public GirlInterface getGril();
	
	/**
	 * ��ȡ�к���װ
	 * @return	BoyInterface����
	 */
	public BoyInterface getBoy();
	
}
