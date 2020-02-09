package com.template_sb_gwt.ui.client.mvp.views.impl;

import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.template_sb_gwt.ui.client.mvp.presenters.PeoplePagePresenter;
import com.template_sb_gwt.ui.client.mvp.views.PeoplePageView;
import com.template_sb_gwt.ui.client.widgets.HumansGrid;

public class PeoplePageViewImpl implements PeoplePageView {
    private PeoplePagePresenter presenter;
    private ContentPanel panel;
    private HumansGrid grid;

    @Override
    public void setPresenter(PeoplePagePresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public Widget asWidget() {
        if (panel == null) {
            grid = new HumansGrid(presenter.getGridProxy());

            panel = new ContentPanel();
            panel.setHeaderVisible(false);
            panel.add(grid);
        }
        return panel;
    }
}
