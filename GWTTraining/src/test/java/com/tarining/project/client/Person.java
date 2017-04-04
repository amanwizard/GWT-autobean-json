package com.tarining.project.client;

import java.util.ArrayList;
import java.util.List;

public class Person implements PersonInterface {

	String name,address;
	ContactInterface contact;
	
	List<Icar> carsList = new ArrayList<Icar>();
	
	ICarList carListInterface;
	

	@Override
	public ContactInterface getContact() {
		return contact;
	}
	@Override
	public void setContact(ContactInterface contact) {
		this.contact = contact;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	public List<Icar> getCarsList() {
		return carsList;
	}
	public void setCarsList(List<Icar> carsList) {
		this.carsList = carsList;
	}
	
	
	
	public ICarList getCarListInterface() {
		return carListInterface;
	}
	public void setCarListInterface(ICarList carListInterface) {
		this.carListInterface = carListInterface;
	}
	public Person(String name, String address,ContactInterface contact,List<Icar> carsList , ICarList carListInterface ) {
		super();
		this.name = name;
		this.address = address;
		this.contact=contact;
		this.carsList = carsList;
		//this.carListInterface = carListInterface; 
	}
	
}
