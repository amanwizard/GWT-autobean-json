package com.tarining.project.client.application.dataforperson.datapresenter;

import java.util.List;

import com.gwtplatform.mvp.client.UiHandlers;

public interface dataPresenterUiHandlers   extends UiHandlers{
	
	public void fetchDetails();
	void display(List<PersonDAO> personList);

}
