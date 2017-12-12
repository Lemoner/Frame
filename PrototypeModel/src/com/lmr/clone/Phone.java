package com.lmr.clone;

import java.io.Serializable;

public class Phone implements Serializable{

	private String number;

	public Phone() {
	}

	public Phone(String number) {
		this.number = number;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Phone [number=" + number + ", hashCode()=" + hashCode() + "]";
	}

}
