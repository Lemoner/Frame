package com.lmr.simple;

/**
 * ����ԭ��
 */
public interface Prototype {

	/**
	 * ��¡����
	 * @return	һ���������¡�����Ķ���
	 */
	public Object clone();
	
	public void setName(String name);
	
	public String getName();
	
	public void setAge(int age);
	
	public int getAge();
	
}
