package com.template_sb_gwt.ui.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.CenterLayoutContainer;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.Viewport;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.TextField;
import com.template_sb_gwt.HomeController;
import com.template_sb_gwt.ui.client.mvp.ApplicationController;

public class Main implements EntryPoint {
    @Override
    public void onModuleLoad() {
        Viewport vp = new Viewport();
        ApplicationController ac = new ApplicationController();
        ac.go(vp);
        RootPanel.get("application").add(vp);
    }
}
