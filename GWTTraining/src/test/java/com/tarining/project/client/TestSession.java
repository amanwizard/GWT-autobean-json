package com.tarining.project.client;

public class TestSession {

	
	

	public static void main(String[] args) {
		
		
		//phoenix
		MallsProfile Phoenix = new MallsProfile();
		Phoenix.setProfileName("Phoenix");
		Phoenix.setOfficeId("1234");
		Cars car =new Cars();
		car.setCarName("Phoenix car");
		car.setModelName("phoen");
		Phoenix.setCars(car);
		
		
		//garuda
		MallsProfile garuda = new MallsProfile();
		garuda.setProfileName("Garuda");
		garuda.setOfficeId("4567");
		Cars cargaruda =new Cars();
		cargaruda.setCarName("Gard car");
		cargaruda.setModelName("Gardu");
		garuda.setCars(car);
		
		
		
		
		MallSession instance = MallSession.getInstance();
				
		
		if(!instance.getMallProfileList().contains(Phoenix))
		{
			instance.getMallProfileList().add(Phoenix);
			System.out.println("added");
		}
		else{
			System.out.println("sorrry");
		}
		
		
		if(!instance.getMallProfileList().contains(garuda))
		{
			instance.getMallProfileList().add(garuda);
			System.out.println("added");
		}
		else{
			System.out.println("sorrry");
		}
		
		
		
		if(!instance.getMallProfileList().contains(Phoenix))
		{
			instance.getMallProfileList().add(Phoenix);
			System.out.println("added ");
		}
		else{
			System.out.println("sorrry");
		}
		
		
	}
	
	
	
	
	
	
}
