package com.lmr.simple;

/**
 * 具体原型角色
 */
public class ConcretePrototype implements Prototype{
	
	private String name;
	private int age;
	
	public ConcretePrototype(String name, int age) {
		this.name=name;
		this.age=age;
	}

	public ConcretePrototype() {
	}
	
	@Override
	public String toString() {
		return "ConcretePrototype "+this.hashCode()+" [name=" + name + ", age=" + age + "]";
	}

	@Override
	public Object clone() {
		ConcretePrototype concretePrototype=new ConcretePrototype();
		concretePrototype.setName(this.getName());
		concretePrototype.setAge(this.getAge());
		return concretePrototype;
	}

	@Override
	public void setName(String name) {
		this.name=name;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setAge(int age) {
		this.age=age;
	}

	@Override
	public int getAge() {
		return this.age;
	}

}
