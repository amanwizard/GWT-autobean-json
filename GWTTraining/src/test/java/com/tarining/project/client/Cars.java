package com.tarining.project.client;

import com.google.gwt.json.client.JSONNumber;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.json.client.JSONValue;

public class Cars implements Icar{

	
	String carName ;
	Double price;
	int modelNo;
	String modelName;
	
	public Cars (){
		
	}
	

	public Cars(String carName) {
		super();
		this.carName = carName;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}


	public int getModelNo() {
		return modelNo;
	}


	public void setModelNo(int modelNo) {
		this.modelNo = modelNo;
	}


	public String getModelName() {
		return modelName;
	}


	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	
	public  JSONObject  encodeProps()
	{
		
		JSONObject obj = new JSONObject();
		obj.put("car_name", new JSONString(this.carName));
		
		obj.put("model_Name", new JSONString(this.modelName));
		
		obj.put("car_price",  new JSONNumber(this.price));
		
		obj.put("car_modelNo",  new JSONNumber(this.modelNo));
		
		
		return obj;
		
	}
	
	
	public  Cars  decodeProps(JSONObject jsonObject)
	{
		JSONValue value = null;
		
		Cars car = new Cars();
		
		for (String key : jsonObject.keySet()) {
			value = jsonObject.get(key);
			
			switch(key)
			{
			case "car_name" : car.setCarName(value.isString().stringValue());
				break;
			case "model_Name" :  car.setModelName(value.isString().stringValue());
				break;
			
			case "car_price" : car.setPrice(value.isNumber().doubleValue());
			break;
			
			case "car_modelNo" : car.setModelNo((int)value.isNumber().doubleValue());
				break;
			}
			
		}
		
		return car;
		
	}
	
	
	
/*	public String encodeProps1()
	{
		
		StringBuilder builder = new  StringBuilder();
		
		builder.append(this.carName);
		builder.append(this.modelName);
		builder.append(this.price);
		builder.append(this.modelNo);
		
		System.out.println(builder.toString());
		
		return builder.toString();
		
	}
	*/
	
	
	
}
