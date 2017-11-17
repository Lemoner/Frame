package com.lmr.intrinsic;

/**
 * 具体聚集
 */
public class ConcreteAggregate extends Aggregate {

	/**
	 * 聚集对象数据
	 */
	private Object[] objects;
	
	public ConcreteAggregate(Object[] objects) {
		this.objects=objects;
	}
	
	@Override
	public Iterator createIterator() {
		return new ConcreteIterator();
	}
	
	/**
	 * 内部成员类，具体迭代子类
	 */
	private class ConcreteIterator implements Iterator {

		/**
		 * 内部索引，记录当前迭代到的索引位置
		 */
		private int index;
		/**
		 * 记录当前聚集数据对象的大小
		 */
		private int size;
		
		public ConcreteIterator() {
			this.size=objects.length;
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
			return objects[index];
		}

	}

}
