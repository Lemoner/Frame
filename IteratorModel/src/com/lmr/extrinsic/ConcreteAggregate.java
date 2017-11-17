package com.lmr.extrinsic;

/**
 * ����ۼ�
 */
public class ConcreteAggregate extends Aggregate {

	/**
	 * �ۼ���������
	 */
	private Object[] objects;
	
	public ConcreteAggregate(Object[] objects) {
		this.objects=objects;
	}
	
	@Override
	public Iterator createIterator() {
		return new ConcreteIterator(this);
	}
	
	/**
	 * ��ȡ�ۼ�Ԫ��
	 * @param index	�±�λ��
	 * @return	��Ӧ�±�λ�õľۼ�Ԫ��
	 */
	public Object getElement(int index){
		if(index<size()){
			return objects[index];
		}
		else{
			return null;
		}
	}
	
	/**
	 * ��ȡ�ۼ����ݴ�С
	 * @return	�ۼ���С
	 */
	public int size(){
		return objects.length;
	}

}
