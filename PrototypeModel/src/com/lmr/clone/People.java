package com.lmr.clone;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class People implements Cloneable,Serializable {

	private String name;
	private int age;
	transient private Phone phone;

	public People() {

	}

	public People(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

	/**
	 * 普通克隆
	 */
	@Override
	protected People clone() {
		People people = null;
		try {
			people = (People) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return people;
	}

	/**
	 * 深度克隆，使用序列化的方式进行
	 * @return	People对象
	 */
	protected People deepclone() {
		People people = null;

		try {
			ByteArrayOutputStream output = new ByteArrayOutputStream();
			ObjectOutputStream outputStream = new ObjectOutputStream(output);
			outputStream.writeObject(this);

			ByteArrayInputStream input = new ByteArrayInputStream(output.toByteArray());
			ObjectInputStream inputStream = new ObjectInputStream(input);
			people = (People) inputStream.readObject();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return people;
	}

	@Override
	public String toString() {
		return "People [name=" + name + ", age=" + age + ", phone=" + phone.hashCode() + ", hashCode()=" + hashCode()
				+ "]";
	}

}
