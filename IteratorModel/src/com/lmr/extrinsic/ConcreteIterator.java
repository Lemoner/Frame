package com.lmr.extrinsic;

/**
 * �������
 */
public class ConcreteIterator implements Iterator {

	/**
	 * ���б������ľ���ľۼ����ݶ���
	 */
	private ConcreteAggregate aggregate;
	/**
	 * �ڲ���������¼��ǰ������������λ��
	 */
	private int index;
	/**
	 * ��¼��ǰ�ۼ����ݶ���Ĵ�С
	 */
	private int size;
	
	public ConcreteIterator(ConcreteAggregate aggregate) {
		this.aggregate=aggregate;
		this.size=aggregate.size();
		this.index=0;
	}
	
	@Override
	public void first() {
		index=0;
	}

	@Override
	public void next() {
		index++;
	}

	@Override
	public boolean isDone() {
		return index>=size;
	}

	@Override
	public Object currentItem() {
		return aggregate.getElement(index);
	}

}
