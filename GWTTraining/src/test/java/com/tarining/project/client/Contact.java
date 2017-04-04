package com.tarining.project.client;

public class Contact implements ContactInterface {

	String type,number;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Contact(String type, String number) {
		super();
		this.type = type;
		this.number = number;
	}
	

}
