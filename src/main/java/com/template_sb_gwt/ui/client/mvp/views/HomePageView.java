package com.template_sb_gwt.ui.client.mvp.views;

import com.google.gwt.user.client.ui.IsWidget;
import com.template_sb_gwt.ui.client.mvp.presenters.HomePagePresenter;

public interface HomePageView extends IsWidget {
    void setPresenter(HomePagePresenter presenter);
}
