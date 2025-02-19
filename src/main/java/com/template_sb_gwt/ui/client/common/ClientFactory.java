package com.template_sb_gwt.ui.client.common;

import com.sencha.gxt.widget.core.client.ContentPanel;
import com.template_sb_gwt.ui.client.events.AppEventBus;
import com.template_sb_gwt.ui.client.mvp.views.HomePageView;
import com.template_sb_gwt.ui.client.mvp.views.PeoplePageView;

public interface ClientFactory {
    AppEventBus getEventBus();
    HomePageView getHomePageView();
    PeoplePageView getPeoplePageView();
    ContentPanel getContentHolder();
}
