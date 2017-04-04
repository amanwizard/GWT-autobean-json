package com.tarining.project.client.application.home;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;

public class JsonEncodingTester {
	
	
	
	
	public void encodeString()
	{
		
	/*	String str = new String("Aman");
		JSONValue value= JSONParser.parse(str);
		
		JSONObject obj = new JSONObject();
		obj.put("name", value);
		
		JSONValue value = JSONParser.parse(str);
		JSONObject object1 = value.isObject();*/
		
		
		// create a JSON object
		// encode a string
		/*String json = "Aman";
		
		JSONValue parse = JSONParser.parse("{'name': 'Aman'}");
		System.out.println(parse);

		JSONObject object = new JSONObject();
		object.put("name", parse);*/
		
		JSONObject obj = new JSONObject();
		obj.put("name", new JSONString("AMan"));
		
		
		System.out.println(obj.get("name"));
		
	}
	
	
	
	public static void main(String[] args) {
		
		
		JsonEncodingTester encoder = new JsonEncodingTester();
		
		encoder.encodeString();
		
		
		
	}

}
