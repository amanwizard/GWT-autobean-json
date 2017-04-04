package com.tarining.project.client;

import java.util.ArrayList;
import java.util.List;

public class CarList implements ICarList {

	private List<Icar> carList = new ArrayList<Icar>();
	
	public List<Icar> getList()
	{
		return carList;
	}
	
	
}
