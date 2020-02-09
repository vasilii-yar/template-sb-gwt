package com.template_sb_gwt.ui.client.common;

import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.MarginData;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.template_sb_gwt.ui.client.events.AppEventBus;
import com.template_sb_gwt.ui.client.mvp.views.HomePageView;
import com.template_sb_gwt.ui.client.mvp.views.PeoplePageView;
import com.template_sb_gwt.ui.client.mvp.views.impl.HomePageViewImpl;
import com.template_sb_gwt.ui.client.mvp.views.impl.PeoplePageViewImpl;

public class ClientFactoryImpl implements ClientFactory{
    private static AppEventBus eventBus;
    private static HomePageView homePageView;
    private static PeoplePageView peoplePageView;
    private static ContentPanel contentHolder;

    @Override
    public AppEventBus getEventBus() {
        if (eventBus == null) {
            eventBus = AppEventBus.getInstance();
        }
        return eventBus;
    }

    @Override
    public HomePageView getHomePageView() {
        if (homePageView == null) {
            homePageView = new HomePageViewImpl();
        }
        return homePageView;
    }

    @Override
    public PeoplePageView getPeoplePageView() {
        if (peoplePageView == null) {
            peoplePageView = new PeoplePageViewImpl();
        }
        return peoplePageView;
    }

    @Override
    public ContentPanel getContentHolder() {
        if (contentHolder == null) {
            ContentPanel panel = new ContentPanel();
            panel.setHeaderVisible(false);
            contentHolder = panel;
        }
        return contentHolder;
    }

}
