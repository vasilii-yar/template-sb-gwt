package com.template_sb_gwt.ui.client.mvp.presenters.impl;

import com.google.gwt.user.client.ui.HasWidgets;
import com.template_sb_gwt.ui.client.mvp.presenters.HomePagePresenter;
import com.template_sb_gwt.ui.client.mvp.views.HomePageView;

public class HomePagePresenterImpl implements HomePagePresenter {
    private final HomePageView view;

    public HomePagePresenterImpl(HomePageView view) {
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
}
