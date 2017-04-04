package com.tarining.project.client.application.demo.person;

import javax.inject.Inject;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

class personView extends ViewWithUiHandlers<personUiHandlers> implements
		personPresenter.MyView {
	interface Binder extends UiBinder<Widget, personView> {
	}

	/*@UiField
	SimplePanel main;*/

	@UiField
	TextBox textbox;
	@UiField
	Label label; 
	
	@UiField
	Button button , clear; 
	
	
	
	

	@Inject
	personView(Binder uiBinder) {
		initWidget(uiBinder.createAndBindUi(this));
		
		
		button.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
			
			    getUiHandlers().passValueToPresenter(textbox.getValue());
				
			}
		});
		
		
		
		
	}

	@UiHandler("clear")
	void onclick(ClickEvent clickEvent)
	{
		getUiHandlers().clear();
	}
	
	
	/*@Override
	public void setInSlot(Object slot, IsWidget content) {
		if (slot == personPresenter.SLOT_person) {
			main.setWidget(content);
		} else {
			super.setInSlot(slot, content);
		}
	}*/

	@Override
	public void setValueIntoTextBox(String value) {
		
		textbox.setText(value);
		
	}

	@Override
	public void setValueIntoLabel(String value) {
	
	   label.setText(value);
	}
}
