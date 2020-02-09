package com.template_sb_gwt.ui.client.widgets.menu_set;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;

import java.util.ArrayList;
import java.util.List;

public class AccordionMenuPanel implements IsWidget {
    private static final int HEAD_WIDTH = 50;
    private final List<MenuItem> menuItems = new ArrayList<>();
    private ContentPanel panel;
    private VerticalLayoutContainer menuContainer;

    public void addMenuItem(MenuItem item) {
        menuItems.add(item);
    }

    @Override
    public Widget asWidget() {
        if (panel == null) {
            panel = new ContentPanel();
            menuContainer = new VerticalLayoutContainer();

            for (MenuItem item : menuItems) {
                menuContainer.add(item, new VerticalLayoutContainer.VerticalLayoutData(1, -1, new Margins(2, 0, 0, 0)));
            }

            panel.setHeading("MyApp");
            panel.getHeader().setHeight(HEAD_WIDTH);
            panel.add(menuContainer);
        }
        return panel;
    }
}
