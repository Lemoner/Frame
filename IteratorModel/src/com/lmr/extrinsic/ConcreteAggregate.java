package com.lmr.extrinsic;

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
		return new ConcreteIterator(this);
	}
	
	/**
	 * 获取聚集元素
	 * @param index	下标位置
	 * @return	对应下标位置的聚集元素
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
	 * 获取聚集数据大小
	 * @return	聚集大小
	 */
	public int size(){
		return objects.length;
	}

}
