package com.tarining.project.client;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;
import com.google.web.bindery.autobean.shared.AutoBean;
import com.google.web.bindery.autobean.shared.AutoBeanCodex;
import com.google.web.bindery.autobean.shared.AutoBeanFactory;
import com.google.web.bindery.autobean.vm.AutoBeanFactorySource;

public class AutoBeanTest {

	// Declare the factory type
	interface MyFactory extends AutoBeanFactory {

		AutoBean<PersonInterface> person();
		AutoBean<ContactInterface> contact();
		AutoBean<PeopleInterface> people();
		AutoBean<Icar> car();
		AutoBean<ICarList> carList();
		
		/* this is to enable use of classes*/
		AutoBean<PeopleInterface> people(PeopleInterface p);
		AutoBean<PersonInterface> person(PersonInterface p);
		AutoBean<Icar> car(Icar car);
		AutoBean<ICarList> carList(ICarList carList);
		
		// wrap existing
	}

	String serializeToJson(PersonInterface person) {
		// Retrieve the AutoBean controller
		MyFactory factory = AutoBeanFactorySource.create(MyFactory.class);
		
		List<Icar> listOfCars = person.getCarsList();
		
		for(Icar carIns : listOfCars)
		{
			factory.car(carIns);
		}
		
		//ICarList carListInterface = person.getCarListInterface();
		
		//factory.carList(carListInterface);
		
		//factory.create(ICarList.class, carList);
		
		AutoBean<PersonInterface> autoBeanPerson = factory.person(person);
		// AutoBean<Person> bean = AutoBeanUtils.getAutoBean(autoBeanPerson);

		return AutoBeanCodex.encode(autoBeanPerson).getPayload();
	}
	String serializeToJson(PeopleInterface people ) {
		// Retrieve the AutoBean controller
		MyFactory factory = AutoBeanFactorySource.create(MyFactory.class);
		AutoBean<PeopleInterface> autoBeanPerson = factory.people(people);
		
		// AutoBean<Person> bean = AutoBeanUtils.getAutoBean(autoBeanPerson);

		return AutoBeanCodex.encode(autoBeanPerson).getPayload();
	}

	PersonInterface deserializeFromJson(String json) {
		AutoBean<PersonInterface> bean = AutoBeanCodex.decode(
				AutoBeanFactorySource.create(MyFactory.class),
				PersonInterface.class, json);
		return bean.as();
	}

	@Test
	public void testEncodePerson() {
		AutoBeanTest test = new AutoBeanTest();
		//list of cars
		/*List<Cars> listOfCars = new ArrayList<Cars>();
		listOfCars.add(new Cars("Audi"));
		listOfCars.add(new Cars("BMW"));
		listOfCars.add(new Cars("Volvo"));
		*/
		//MyFactory factory = AutoBeanFactorySource.create(MyFactory.class);
		
		MyFactory  factory = AutoBeanFactorySource.create(MyFactory.class);
	ICarList carList = new CarList();
	carList.getList().add(new Cars("Audi"));
	carList.getList().add(new Cars("BMW"));
	//factory.create(ICarList.class, carList);
		
		String serializeToJson = test.serializeToJson(new Person("Aman", "Bixera",new Contact("mobile", "9121211212"),carList.getList(),carList));
		System.out.println(serializeToJson);
		//Assert.assertEquals("{\"address\":\"Bixera\",\"name\":\"Aman\"}", serializeToJson);
		Assert.assertEquals("{\"address\":\"Bixera\",\"contact\":{\"number\":\"9121211212\",\"type\":\"mobile\"},\"name\":\"Aman\",\"carsList\":[{\"carName\":\"Audi\"},{\"carName\":\"BMW\"}]}", serializeToJson);
	}
	
	@Test
	public void testEncodePeople() {
		AutoBeanTest test = new AutoBeanTest();
		
		MyFactory  factory = AutoBeanFactorySource.create(MyFactory.class);
		ICarList carList = new CarList();
		carList.getList().add(new Cars("Audi"));
		carList.getList().add(new Cars("BMW"));
		factory.create(ICarList.class, carList);
		
		List <PersonInterface> peopleList = new ArrayList<PersonInterface>();
		peopleList.add(new Person("Aman", "Bixera",new Contact("mobile", "9121211212"),carList.getList(),carList));
		peopleList.add(new Person("Vishnu", "Bixera",new Contact("mobile", "9121211212"),carList.getList(),carList));		
		
		String serializeToJson = test.serializeToJson(new People(peopleList));
		System.out.println(serializeToJson);
		Assert.assertEquals("{\"address\":\"Bixera\",\"name\":\"Aman\"}", serializeToJson);
	}
	
	@Test
	public void testDecodePerson() {
		AutoBeanTest test = new AutoBeanTest();
		PersonInterface result = test.deserializeFromJson("{\"address\":\"Bixera\",\"contact\":{\"number\":\"9121211212\",\"type\":\"mobile\"},\"name\":\"Aman\",\"carsList\":[{\"carName\":\"Audi\"},{\"carName\":\"BMW\"}]}");
		Assert.assertEquals("Aman", result.getName());
		Assert.assertEquals("Bixera", result.getAddress());
		Assert.assertEquals("Audi", result.getCarsList().get(0).getCarName());
	}
	
	
	
	//My Tester
	
	/*public void jsonEncodeString()
	{
		
		// create a Json object
		//JSONObject jsonobj = new JSONObject();
		JSONValue parse = JSONParser.parse("Aman");
		JSONObject object = parse.isObject();
		//jsonobj.put("name", valName);
		
		System.out.println(object);
		
		// encode - Double , Float , List , Boolean
		
		
		
		// Encode objects - call encode method of its builder
		
		
		
	}

	

	@Test
	public void testJsonEncodeString() {
		
		jsonEncodeString();
		
	}
	
	
	*/
	
	
	
	
	
	
	
	
	
	
	
}
