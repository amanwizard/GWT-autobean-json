package com.tarining.project.client.application.demo.person;

import com.gwtplatform.mvp.client.UiHandlers;

interface personUiHandlers extends UiHandlers {

	void passValueToPresenter(String value);
	
	void clear();
	
	
}
