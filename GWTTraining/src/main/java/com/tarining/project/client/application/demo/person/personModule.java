package com.tarining.project.client.application.demo.person;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class personModule extends AbstractPresenterModule {
	@Override
	protected void configure() {
		bindPresenter(personPresenter.class, personPresenter.MyView.class,
				personView.class, personPresenter.MyProxy.class);
	}
}
