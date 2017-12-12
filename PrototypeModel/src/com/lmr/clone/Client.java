package com.lmr.clone;

public class Client {

	public static void main(String[] args) throws CloneNotSupportedException {
		
		People people=new People("Jane",11);
		Phone phone=new Phone();
		people.setPhone(phone);
		
		People copypeople=people.clone();
		
		System.out.println(people.toString());
		System.out.println(copypeople.toString());
		System.out.println(people.equals(copypeople));
		System.out.println(people.getPhone().equals(copypeople.getPhone()));
		
		People deeppeople=people.deepclone();
		
		System.out.println(people.toString());
		System.out.println(deeppeople.toString());
		System.out.println(people.equals(deeppeople));
		System.out.println(people.getPhone().equals(deeppeople.getPhone()));
		
	}
	
}
