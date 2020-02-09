package com.template_sb_gwt.ui.client.mvp.presenters;

import com.sencha.gxt.data.client.loader.HttpProxy;
import com.sencha.gxt.data.shared.loader.ListLoadConfig;

public interface PeoplePagePresenter extends Presenter {
    HttpProxy<ListLoadConfig> getGridProxy();
}
