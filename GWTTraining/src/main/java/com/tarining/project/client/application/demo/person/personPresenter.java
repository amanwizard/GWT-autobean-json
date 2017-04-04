 package com.tarining.project.client.application.demo.person;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.gwt.user.client.Cookies;
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

public class personPresenter extends
		Presenter<personPresenter.MyView, personPresenter.MyProxy> implements
		personUiHandlers {
	interface MyView extends View, HasUiHandlers<personUiHandlers> {
		
		
		void setValueIntoLabel(String value);


		void setValueIntoTextBox(String value);
		
		
		
	}

	@ContentSlot
	public static final Type<RevealContentHandler<?>> SLOT_person = new Type<RevealContentHandler<?>>();

	@NameToken(NameTokens.person)
	@ProxyCodeSplit
	interface MyProxy extends ProxyPlace<personPresenter> {
	}

	@Inject
	personPresenter(EventBus eventBus, MyView view, MyProxy proxy) {
		super(eventBus, view, proxy, RevealType.Root);

		getView().setUiHandlers(this);
	}

	@Override
	protected void onReveal() {
	
		super.onReveal();
		
		cookieTester();
		
		getView().setValueIntoTextBox("Hello Aman");
		
		///getView().setValueIntoLabel("Hello Aman");
		
	}
	
	
	
	public void cookieTester()
	{
		
		Date now = new Date();
		long nowLong = now.getTime();
		Logger.getLogger("test").log(Level.INFO, "current Time "+nowLong);
		//nowLong = nowLong + (1000 * 60 * 60 * 24 * 7);//seven days
		nowLong = nowLong + (1000 * 2);// 2 milliseconds
		Logger.getLogger("test").log(Level.INFO, "Exp Time "+nowLong);
		now.setTime(nowLong);

		Cookies.setCookie("sampleCookieName", "sampleCookiValue", now);

		
		 int exp =  (1000 * 3600 * 4) ; //4 hours
		 
		 //int twoSec = 1000*2;
			
		 Date expires = new Date(System.currentTimeMillis() + exp);
		 
			Cookies.setCookie("exp", "Four Hours", expires);
			
			//Window.alert("" +System.currentTimeMillis() );
	}
	
	
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
	public void passValueToPresenter(String value) {
		
		getView().setValueIntoLabel(value);
		
	}

	@Override
	public void clear() {
		
		getView().setValueIntoLabel("");
	}
}
