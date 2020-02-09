package com.template_sb_gwt.ui.client.mvp.presenters.impl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HasWidgets;
import com.sencha.gxt.data.client.loader.HttpProxy;
import com.sencha.gxt.data.shared.loader.ListLoadConfig;
import com.template_sb_gwt.ui.client.mvp.presenters.PeoplePagePresenter;
import com.template_sb_gwt.ui.client.mvp.views.PeoplePageView;

public class PeoplePagePresenterImpl implements PeoplePagePresenter {
    private final static String HUMANS_URL =GWT.getModuleBaseURL() + "rest/peoples";
    private final PeoplePageView view;

    public PeoplePagePresenterImpl(PeoplePageView view) {
        this.view = view;
        bind();
    }

    @Override
    public void go(HasWidgets container) {
        container.clear();
        container.add(view.asWidget());
    }

    @Override
    public void bind() {
        view.setPresenter(this);
    }

    @Override
    public HttpProxy<ListLoadConfig> getGridProxy() {
        RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, HUMANS_URL);
        return new HttpProxy<>(builder);
    }
}
