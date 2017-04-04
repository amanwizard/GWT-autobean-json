package com.tarining.project.client;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Test;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.junit.client.GWTTestCase;

public class TesterGwt extends GWTTestCase{

	@Override
	public String getModuleName() {
		return "com.tarining.project.GWTTraining";
	}
	
	
	
	public void jsonEncodeString()
	{
		
		// create a Json object
		//JSONObject jsonobj = new JSONObject();
		
		JSONObject obj = new JSONObject();
		obj.put("name", new JSONString("Aman"));
		
		
		Logger.getLogger("XYZ").log(Level.INFO, obj.get("name").toString());
		
		//jsonobj.put("name", valName);
		
		
		
		// encode - Double , Float , List , Boolean
		
		
		// Encode objects - call encode method of its builder
		
		
	}

	
	@Test
	public void testStringEncode()
	{
		jsonEncodeString();
	}
	

}
