package com.tarining.project.client;

public class MallsProfile {
	
	
	
	
	//Props

		String profileName;

		String officeId;

		// check on this basis
		Cars cars;

		public String getProfileName() {
			return profileName;
		}

		public void setProfileName(String profileName) {
			this.profileName = profileName;
		}

		public String getOfficeId() {
			return officeId;
		}

		public void setOfficeId(String officeId) {
			this.officeId = officeId;
		}

		public Cars getCars() {
			return cars;
		}

		public void setCars(Cars cars) {
			this.cars = cars;
		}

	
	
	
	
	
	
	/*public static void main(String[] args) {
		
		
		//phoneix 
		MallSession mallSession = new MallSession();
		mallSession.setProfileName("Phoenix");
		mallSession.setOfficeId("1234");
		Cars car =new Cars();
		car.setCarName("Phoenix car");
		car.setModelName("phoen");
		mallSession.setCars(car);
		
		
		if(!mallSession.getMallSessionList().contains(mallSession))
		{
			mallSession.getMallSessionList().add(mallSession);
			System.out.println("added");
		}
		else{
			System.out.println("sorrry");
		}
		
		
		//garuda
		MallSession garuda = new MallSession();
		garuda.setProfileName("Garuda");
		garuda.setOfficeId("4567");
		Cars cargaruda =new Cars();
		cargaruda.setCarName("Gard car");
		cargaruda.setModelName("Gardu");
		garuda.setCars(car);
		
		
		
		
		
		
	}*/
	
	
}
