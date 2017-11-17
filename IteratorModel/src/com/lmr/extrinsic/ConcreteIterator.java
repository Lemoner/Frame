package com.lmr.extrinsic;

/**
 * 具体迭代
 */
public class ConcreteIterator implements Iterator {

	/**
	 * 持有被迭代的具体的聚集数据对象
	 */
	private ConcreteAggregate aggregate;
	/**
	 * 内部索引，记录当前迭代到的索引位置
	 */
	private int index;
	/**
	 * 记录当前聚集数据对象的大小
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
