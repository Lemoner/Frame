package com.lmr.intrinsic;

public class Client {

	public static void main(String[] args) {
		
		Object[] objects={"one","two","three","four","five","six"};
		
		Aggregate aggregate=new ConcreteAggregate(objects);
		Iterator iterator=aggregate.createIterator();
		
		while(!iterator.isDone()){
			System.out.println(iterator.currentItem());
			iterator.next();
		}
		
	}
	
}
