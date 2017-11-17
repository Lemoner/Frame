package com.lmr.intrinsic;

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
		return new ConcreteIterator();
	}
	
	/**
	 * �ڲ���Ա�࣬�����������
	 */
	private class ConcreteIterator implements Iterator {

		/**
		 * �ڲ���������¼��ǰ������������λ��
		 */
		private int index;
		/**
		 * ��¼��ǰ�ۼ����ݶ���Ĵ�С
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
