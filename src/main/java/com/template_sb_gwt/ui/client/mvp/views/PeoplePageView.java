package com.template_sb_gwt.ui.client.mvp.views;

import com.google.gwt.user.client.ui.IsWidget;
import com.template_sb_gwt.ui.client.mvp.presenters.PeoplePagePresenter;
import com.template_sb_gwt.ui.client.mvp.presenters.Presenter;

public interface PeoplePageView extends IsWidget {
    void setPresenter(PeoplePagePresenter presenter);
}
