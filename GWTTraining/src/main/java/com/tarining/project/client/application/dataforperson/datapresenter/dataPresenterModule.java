package com.tarining.project.client.application.dataforperson.datapresenter;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class dataPresenterModule extends AbstractPresenterModule {
	@Override
	protected void configure() {
		bindPresenter(dataPresenterPresenter.class,
				dataPresenterPresenter.MyView.class, dataPresenterView.class,
				dataPresenterPresenter.MyProxy.class);
	}
}
