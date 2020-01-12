package com.template_sb_gwt.ui.client.widgets.menu_set;

import com.google.gwt.core.client.GWT;
import com.sencha.gxt.widget.core.client.Composite;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.template_sb_gwt.ui.client.common.ClientFactory;
import com.template_sb_gwt.ui.client.common.Tokens;
import com.template_sb_gwt.ui.client.events.AppEventBus;
import com.template_sb_gwt.ui.client.events.MenuClickEvent;

public class MenuItem extends Composite {
    private static final ClientFactory CLIENT_FACTORY = GWT.create(ClientFactory.class);
    private final TextButton item;
    private final Tokens token;

    public MenuItem(String itemName, Tokens token) {
        this.token = token;

        item = new TextButton(itemName);
        item.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent event) {
                MenuClickEvent menuEvent = new MenuClickEvent(token);
                AppEventBus.getInstance().fireEvent(menuEvent);
            }
        });

        initWidget(item);
    }
}
