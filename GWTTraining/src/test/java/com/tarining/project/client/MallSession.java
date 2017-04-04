package com.tarining.project.client;

import java.util.ArrayList;
import java.util.List;

public class MallSession {
	
	
	private MallSession() {
		
		
	}
	
	static MallSession instance = null;
	
	public static MallSession getInstance()
	{
		
		if(instance == null)
		{
			instance = new MallSession();
		}
		
		return instance;
		
	}
	

	List<MallsProfile> mallProfileList = new ArrayList<MallsProfile>();

	public List<MallsProfile> getMallProfileList() {
		return mallProfileList;
	}



	public void setMallProfileList(List<MallsProfile> mallProfileList) {
		this.mallProfileList = mallProfileList;
	}



	
}
