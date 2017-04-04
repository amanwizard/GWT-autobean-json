package com.tarining.project.client;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Test;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONBoolean;
import com.google.gwt.json.client.JSONNumber;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.junit.client.GWTTestCase;
import com.google.gwt.user.client.Cookies;

public class JsonEncodingTest extends GWTTestCase {

	@Override
	public String getModuleName() {
		return "com.tarining.project.GWTTraining";
	}

	
	
	
	// Encode String
	public JSONObject jsonEncodeString(String name) {

		// create a Json object
		JSONObject obj = new JSONObject();
		obj.put("name", new JSONString(name));

		Logger.getLogger("XYZ").log(Level.INFO, obj.get("name").toString());

		return obj;

	}

	
	
	
	// Decode String
	public String decodeString(JSONObject jsonObject) {

		JSONValue jsonValue = null;

		for (String key : jsonObject.keySet()) {
			jsonValue = jsonObject.get(key);
		}

		return jsonValue.isString().stringValue();
	}

	
	
	
	/* ENCODE DOUBLE */
	public JSONObject encodeDouble(Double val) {
		// create JSON object
		JSONObject obj = new JSONObject();

		// obj.put("Double", new JSONString("" +val));

		obj.put("Double", new JSONNumber(val));

		return obj;
	}
	
	

	/* DECODE DOUBLE */
	public Double decodeDouble(JSONObject jsonObject) {

		JSONValue jsonValue = null;

		for (String key : jsonObject.keySet()) {
			jsonValue = jsonObject.get(key);
		}

		/* JSONValue jsonValue = jsonObject.get("Double"); */

		Double number = jsonValue.isNumber().doubleValue();

		return number;
	}
	
	

	// Encode Boolean
	public JSONObject encodeBoolean(Boolean val) {

		JSONObject obj = new JSONObject();

		obj.put("Boolean", JSONBoolean.getInstance(val));

		return obj;

	}

	
	
	// DECODE BOOLEAn
	public Boolean decodeBoolean(JSONObject jsonObject) {
		JSONValue jsonValue = null;

		for (String key : jsonObject.keySet()) {
			jsonValue = jsonObject.get(key);
		}

		return jsonValue.isBoolean().booleanValue();

	}

	
	
	
	// Encode List
	public JSONObject encodeList(List<String> list) {
		// create a json array
		JSONArray jsonarray = new JSONArray();

		// add the list to the json array
		for (int i = 0; i < list.size(); i++) {
			jsonarray.set(i, new JSONString(list.get(i)));
		}

		// add json array to the json object
		JSONObject obj = new JSONObject();
		obj.put("list", jsonarray);

		return obj;
	}

	
	
	
	// decode List
	public List<String> decodeStringList(JSONObject jsonObject) {

		JSONValue jsonValue = null;

		for (String key : jsonObject.keySet()) {
			jsonValue = jsonObject.get(key);
		}

		JSONArray array = jsonValue.isArray();
		

		List<String> list = new ArrayList<String>();

		for (int i = 0; i < array.size(); i++) {
			JSONValue value = array.get(i);
			if (value.isString() != null) {
				list.add(value.isString().stringValue());
			}

		}

		return list;

	}
	
	
	

	// Encode object
	public JSONObject encodeObject(Cars car) {

		JSONObject obj = new JSONObject();

		JSONObject encodeProps = car.encodeProps();

		obj.put("car", encodeProps);

		return obj;
	}
	
	

	public Cars decodeObject(JSONObject jsonObject) {

		JSONValue value = null;
		
		Cars car = new Cars();
		
		for (String key : jsonObject.keySet()) {
			value = jsonObject.get(key);
			car = car.decodeProps(value.isObject());
		}
		

		return car;

	}

	//Encode List of Objects
	public JSONObject encodeListOfObjects(List<Cars> list)
	{
		JSONObject obj = new JSONObject();
		
		JSONArray jsonArray = new JSONArray();
		
		for(int i=0 ; i<list.size() ; i++)
		{
			JSONObject encodeObject = encodeObject(list.get(i));
			jsonArray.set(i, encodeObject);
		}
		
		obj.put("Car_list", jsonArray);
		
		return obj;
	}
	
	
	public List<Cars>  decodeListOfObjects(JSONObject jsonObject)
	{
		List<Cars> carList = new ArrayList<Cars>();
		
		JSONValue value = null;
		
		for (String key : jsonObject.keySet()) {
			value = jsonObject.get(key);
		}
		JSONArray array = value.isArray();
		
		for(int i=0 ; i<array.size() ; i++)
		{
			JSONValue jsonValue = array.get(i);
			
			Cars decodeObject = decodeObject(jsonValue.isObject());
			carList.add(decodeObject);
		}
		
		
		return carList;
	}
	
	
	public JSONObject encodeDate(Date date)
	{
		JSONObject jsonObject = new JSONObject();
		
		
		
		
		return jsonObject;
		
	}
	
	
	
	
	@Test
	public void testEncodeingDate()
	{
		
	}
	
	/* Test cases for all the functional blocks */
	@Test
	public void testEncodeString() {

		JSONValue jsonObj = jsonEncodeString("Aman");
		// jsonEncodeString.replaceAll("\"", "");

		System.out.println(jsonObj);

		assertEquals("{\"name\":\"Aman\"}", jsonObj.toString());

	}

	
	
	
	@Test
	public void testDecodeString() {

		// This function gives you encoded string
		JSONObject jsonObj = jsonEncodeString("Aman");

		String decodeString = decodeString(jsonObj);

		System.out.println("\n......................................");
		System.out.println(decodeString);
		System.out.println("......................................");

		assertEquals("Aman", decodeString);

	}

	
	@Test
	public void testEncodeDate()
	{
		//encode
		Date date = new Date();
		
		JSONObject jsonObj = new JSONObject();
		DateTimeFormat fmt = DateTimeFormat.getFormat("MM-dd-yyyy:hh:mm:ss");
		jsonObj.put("Date", new JSONString(fmt.format(date)));
		
		System.out.println(jsonObj);
		
		//decode
		JSONValue jsonValue = jsonObj.get("Date");
		//SimpleDateFormat dateFormat = new SimpleDateFormat(jsonValue.isString().stringValue());
		String dateStr = jsonValue.isString().stringValue();
		System.out.println(dateStr);

		
		Date parseStrict = fmt.parseStrict(dateStr);
	// Date parse = DateTimeFormat.getFormat("MM-dd-yyyy").parse("12:19:16");
		
		System.out.println(parseStrict.toString()); // Sat Jan 02 00:00:00 GMT 2010
		
	}
	
	/* test encode */

	@Test
	public void testEncodeDouble() {

		JSONObject encodeDouble = encodeDouble(50.34);

		System.out.println("\n.....DOUBLE.......................");
		System.out.println(encodeDouble);
		System.out.println("............................\n");

		// check for JSON format
		assertEquals("{\"Double\":50.34}", encodeDouble.toString());
	}

	
	
	@Test
	public void testDecodeDouble() {

		// get encode value
		JSONObject encodeDouble = encodeDouble(50.34);

		System.out.println("\n.....DOUBLE Encoded.......................");
		System.out.println(encodeDouble);
		System.out.println("............................\n");

		// call decode function
		Double decodeDouble = decodeDouble(encodeDouble);

		System.out.println("\n.....DOUBLE Decoded.......................");
		System.out.println(decodeDouble);
		System.out.println("............................\n");

		assertEquals(new Double(50.34), decodeDouble);

	}
	
	
	

	@Test
	public void testEncodeBoolean() {

		JSONObject encodeBoolean = encodeBoolean(true);

		JSONObject encodeBoolean2 = encodeBoolean(false);
		
		System.out.println("\n........BOOLEAN Encoded..................");

		System.out.println(encodeBoolean);

		System.out.println("............................\n");

		System.out.println("\n........BOOLEAN Encoded..................");

		System.out.println(encodeBoolean2);

		System.out.println("............................\n");

		assertEquals("{\"Boolean\":true}", encodeBoolean.toString());

		assertEquals("{\"Boolean\":false}", encodeBoolean2.toString());

	}

	
	
	
	@Test
	public void testDecodeBoolean() {

		JSONObject encodeBoolean = encodeBoolean(true);

		System.out.println("\n........BOOLEAN Encoded..................");

		System.out.println(encodeBoolean);

		System.out.println("............................\n");

		Boolean decodeBoolean = decodeBoolean(encodeBoolean);

		System.out.println("\n........BOOLEAN Decoded..................");
		System.out.println(decodeBoolean);
		System.out.println("............................\n");

		assertEquals(true, decodeBoolean.booleanValue());

	}

	
	
	
	@Test
	public void testEncodeList() {
		List<String> list = new ArrayList<String>();
		list.add("aman");
		list.add("kareem");
		list.add("Vinay");

		JSONObject encodeList = encodeList(list);

		System.out.println("\n..........ARRAY LIST Encoded..................");
		System.out.println(encodeList);
		System.out.println("............................\n");

		assertEquals("{\"list\":[\"aman\",\"kareem\",\"Vinay\"]}",
				encodeList.toString());

	}

	
	
	
	@Test
	public void testDecodeList() {

		List<String> list = new ArrayList<String>();
		list.add("aman");
		list.add("kareem");
		list.add("Vinay");

		JSONObject encodeList = encodeList(list);
		System.out.println("\n..........ARRAY LIST Encoded..................");
		System.out.println(encodeList);
		System.out.println("............................\n");

		// decode the encoded list
		List<String> decodeList = decodeStringList(encodeList);

		assertNotNull(decodeList);

		assertEquals("aman", decodeList.get(0));

	}

	
	
	
	
	@Test
	public void testEncodeObject() {

		Cars car = new Cars();
		car.setCarName("Ford mustang");
		car.setModelName("GT");
		car.setPrice(2500000.450);
		car.setModelNo(3456);

		JSONObject encodeObject = encodeObject(car);

		System.out.println("\n........OBJECT ENCODING....................");
		System.out.println(encodeObject);
		System.out.println("............................\n");

		assertEquals(
				"{\"car\":{\"car_name\":\"Ford mustang\", \"model_Name\":\"GT\", \"car_price\":2500000.45, \"car_modelNo\":3456}}",
				encodeObject.toString());

	}

	
	
	
	// decode a object from a JSON Object
	@Test
	public void testDecodeObject() {
		Cars car = new Cars();
		car.setCarName("Ford mustang");
		car.setModelName("GT");
		car.setPrice(2500000.450);
		car.setModelNo(3456);

		JSONObject encodeObject = encodeObject(car);
		
		
		Cars decodeObject = decodeObject(encodeObject);
		assertNotNull(decodeObject);

		assertEquals("Ford mustang", decodeObject.getCarName());
		
		assertEquals("GT", decodeObject.getModelName());
	}
	
	
	
	
	@Test
	public void testEncodeListOfObjects()
	{ 
		List<Cars> carList = new ArrayList<Cars>();
		
		// obj 1
		Cars car1 = new Cars();
		car1.setCarName("Ford mustang");
		car1.setModelName("GT");
		car1.setPrice(2500000.450);
		car1.setModelNo(3456);
		
		carList.add(car1);
		
		// obj2
		Cars car2 = new Cars();
		car2.setCarName("Porsche");
		car2.setModelName("Turbo 911 GT");
		car2.setPrice(2500000.450);
		car2.setModelNo(3156);
		
		carList.add(car2);
		
		
		JSONObject encodeListOfObjects = encodeListOfObjects(carList);
		
		System.out.println("\n........List of OBJECT ENCODING....................");
		System.out.println(encodeListOfObjects);
		System.out.println("............................\n");
		
		
		assertEquals("{\"Car_list\":[{\"car\":{\"car_name\":\"Ford mustang\", \"model_Name\":\"GT\", \"car_price\":2500000.45, \"car_modelNo\":3456}},"
		                        + "{\"car\":{\"car_name\":\"Porsche\", \"model_Name\":\"Turbo 911 GT\", \"car_price\":2500000.45, \"car_modelNo\":3156}}]}", encodeListOfObjects.toString());
		
	}
	
	@Test
	public void testDecodeListOfObjects()
	{ 

		List<Cars> carList = new ArrayList<Cars>();
		
		// obj 1
		Cars car1 = new Cars();
		car1.setCarName("Ford mustang");
		car1.setModelName("GT");
		car1.setPrice(2500000.450);
		car1.setModelNo(3456);
		
		carList.add(car1);
		
		// obj2
		Cars car2 = new Cars();
		car2.setCarName("Porsche");
		car2.setModelName("Turbo 911 GT");
		car2.setPrice(2500000.450);
		car2.setModelNo(3156);
		
		carList.add(car2);
		
		// Encoded
		JSONObject encodeListOfObjects = encodeListOfObjects(carList);
		
		
		//Decoded
		List<Cars> decodeListOfObjects = decodeListOfObjects(encodeListOfObjects);
		
		System.out.println(decodeListOfObjects.get(0).getCarName());
		
	//assert size
		assertEquals(2, decodeListOfObjects.size());
		
		assertTrue(decodeListOfObjects.get(0).getCarName().contains("Ford mustang"));
		
		assertTrue(decodeListOfObjects.get(1).getCarName().contains("Porsche"));
		
	}
	
	
	@Test
	public void testCookieInValiation()
	{
	 int exp =  (1000 * 3600 * 4) ; //4 hours
	
	 Date expires = new Date(System.currentTimeMillis() + exp);
	 
		Cookies.setCookie("exp", "Four Hours", expires);
		
		
		Date current = new Date();
		DateTimeFormat formatter = DateTimeFormat.getFormat("MM-dd-yyyy:hh:mm:ss");
		String format = formatter.format(current);
		 current = formatter.parseStrict(format);
		 System.out.println("exp date: "+current);
		 
		 
		Date expDate = new Date();
		String format2 = formatter.format(expDate);
		expDate = formatter.parseStrict(format2);
		
		long time = expDate.getTime();
		//expDate.setTime(time-2);
		expDate.setHours(current.getHours()-2);
		System.out.println("exp date: "+expDate);
		
	}
	
	
	@Test
	public void testDateTime()
	{
		Date date = new Date();
		DateTimeFormat formatter = DateTimeFormat.getFormat("MM-dd-yyyy:hh:mm:ss");
		
		System.out.println(formatter.format(date));
		
		DateTimeFormat formatter1 = DateTimeFormat.getFormat("MM-dd-yyyy:HH:mm:ss");

		System.out.println(formatter1.format(date));
		
	}

	
	@Test
	public void testJSNI()
	{
		String event = "aman";
		localyticsTag( event);
		}
	
	
	public native static void localyticsTag(String event) /*-{
		
		
		
	}-*/;
	
	
	
}
