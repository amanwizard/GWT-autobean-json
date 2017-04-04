package com.tarining.project.client;

import java.util.List;

interface PersonInterface {
	String getAddress();

	String getName();

	void setName(String name);

	void setAddress(String a);

	ContactInterface getContact();

	void setContact(ContactInterface contact);
	
	 List<Icar> getCarsList();
	
	 void setCarsList(List<Icar> carsList);
	 
	 ICarList getCarListInterface();
	 
	 void setCarListInterface(ICarList carListInterface);
}