package com.lmr.extrinsic;

/**
 * �����ӿ�
 */
public interface Iterator {

	/**
	 * �ƶ�����һ��Ԫ��
	 */
	public void first();
	
	/**
	 * �ƶ�����һ��Ԫ��
	 */
	public void next();
	
	/**
	 * �Ƿ��������
	 * @return	true��������<br>
	 * 			false����Ԫ��δ����
	 */
	public boolean isDone();
	
	/**
	 * ���ص�ǰ������Ԫ��
	 * @return	��ǰ������Ԫ��
	 */
	public Object currentItem();
	
}
