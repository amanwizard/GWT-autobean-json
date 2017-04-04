package com.tarining.project.client.application;

import com.tarining.project.client.application.home.HomeModule;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.tarining.project.client.application.demo.person.personModule;
import com.tarining.project.client.application.dataforperson.datapresenter.dataPresenterModule;

public class ApplicationModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        install(new dataPresenterModule());
		install(new personModule());
		install(new HomeModule());

        bindPresenter(ApplicationPresenter.class, ApplicationPresenter.MyView.class, ApplicationView.class,
                ApplicationPresenter.MyProxy.class);
    }
}
