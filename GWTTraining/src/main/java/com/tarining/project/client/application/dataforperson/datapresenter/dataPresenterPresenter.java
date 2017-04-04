package com.tarining.project.client.application.dataforperson.datapresenter;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ContentSlot;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;
import com.tarining.project.client.place.NameTokens;

public class dataPresenterPresenter
		extends
		Presenter<dataPresenterPresenter.MyView, dataPresenterPresenter.MyProxy>
		implements dataPresenterUiHandlers {
	interface MyView extends View  , HasUiHandlers<dataPresenterUiHandlers>{

		public String getname();
		

		public Integer getAge();

		public String getMoblileNumber();

		public String getEmail();
		public void settable(List<PersonDAO> personList);

	}

	@ContentSlot
	public static final Type<RevealContentHandler<?>> SLOT_dataPresenter = new Type<RevealContentHandler<?>>();

	@NameToken(NameTokens.data)
	@ProxyCodeSplit
	interface MyProxy extends ProxyPlace<dataPresenterPresenter> {
	}

	@Inject
	dataPresenterPresenter(EventBus eventBus, MyView view, MyProxy proxy) {
		super(eventBus, view, proxy, RevealType.Root);
		getView().setUiHandlers(this);
	}

	/* PersonDAO person = new PersonDAO(); */
	
	List<PersonDAO> personList = new ArrayList<PersonDAO>();

	protected void onBind() {
		super.onBind();

	}

	protected void onHide() {
		super.onHide();
	}

	protected void onReset() {
		super.onReset();
	}

	@Override
	public void fetchDetails() {

		
		PersonDAO	person = new PersonDAO();
		person.setFullName(getView().getname());
		person.setAge(getView().getAge());
		person.setMobileNumber(getView().getMoblileNumber());
		person.setEmailID(getView().getEmail());
		personList.add(person);
		display(personList);

	}

	@Override
	public void display(List<PersonDAO> personList) {
		
		
		getView().settable(personList);
	
		
	}

	
}
