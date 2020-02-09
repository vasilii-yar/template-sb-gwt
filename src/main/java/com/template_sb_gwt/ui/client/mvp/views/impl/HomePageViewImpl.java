package com.template_sb_gwt.ui.client.mvp.views.impl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.Style;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import com.sencha.gxt.widget.core.client.container.CenterLayoutContainer;
import com.sencha.gxt.widget.core.client.container.MarginData;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.template_sb_gwt.ui.client.common.ClientFactory;
import com.template_sb_gwt.ui.client.common.Tokens;
import com.template_sb_gwt.ui.client.mvp.presenters.HomePagePresenter;
import com.template_sb_gwt.ui.client.mvp.views.HomePageView;
import com.template_sb_gwt.ui.client.widgets.menu_set.AccordionMenuPanel;
import com.template_sb_gwt.ui.client.widgets.menu_set.MenuItem;

public class HomePageViewImpl implements HomePageView {
    private static final ClientFactory CLIENT_FACTORY = GWT.create(ClientFactory.class);
    private final ContentPanel content = CLIENT_FACTORY.getContentHolder();
    private HomePagePresenter presenter;
    private BorderLayoutContainer panel;
    private AccordionMenuPanel accordion;

    @Override
    public void setPresenter(HomePagePresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public Widget asWidget() {
        content.clear();
        HTML html = new HTML("<h1 style=\"text-align: center;\">Start page content!</h1>");
        content.add(html);

        if (panel == null) {
            accordion = new AccordionMenuPanel();

            MenuItem menu1 = new MenuItem("Start menu", Tokens.START);
            MenuItem menu2 = new MenuItem("People", Tokens.PEOPLE);

            accordion.addMenuItem(menu1);
            accordion.addMenuItem(menu2);

            ContentPanel rightPanel = new ContentPanel();
            rightPanel.setHeading("Desktop");
            rightPanel.add(content, new MarginData(5, 10, 5, 5));

            panel = new BorderLayoutContainer();
            panel.setWestWidget(accordion, new BorderLayoutContainer.BorderLayoutData(0.10));
            panel.setCenterWidget(rightPanel, new BorderLayoutContainer.BorderLayoutData(0.90));

        }
        return panel;
    }
}
