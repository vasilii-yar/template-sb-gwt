package com.template_sb_gwt.ui.client.mvp;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HasWidgets;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.template_sb_gwt.ui.client.common.ClientFactory;
import com.template_sb_gwt.ui.client.common.Tokens;
import com.template_sb_gwt.ui.client.events.AppEventBus;
import com.template_sb_gwt.ui.client.events.MenuClickEvent;
import com.template_sb_gwt.ui.client.events.MenuClickEventHandler;
import com.template_sb_gwt.ui.client.mvp.presenters.Presenter;
import com.template_sb_gwt.ui.client.mvp.presenters.impl.HomePagePresenterImpl;

import static com.template_sb_gwt.ui.client.common.Tokens.START;

public class ApplicationController implements ValueChangeHandler<String> {
    private static final ClientFactory CLIENT_FACTORY = GWT.create(ClientFactory.class);
    private final AppEventBus eventBus;
    private final ContentPanel desktop;

    public ApplicationController() {
        this.eventBus = CLIENT_FACTORY.getEventBus();
        this.desktop = new ContentPanel();
        this.desktop.setHeaderVisible(false);
        bind();
    }
    private void bind() {
        History.addValueChangeHandler(this);

        eventBus.addHandler(MenuClickEvent.TYPE, new MenuClickEventHandler() {
            @Override
            public void onClickMenu(MenuClickEvent event) {
                Tokens token = event.getToken();
                History.newItem(token.name().toLowerCase());
            }
        });
    }

    public void go(final HasWidgets container) {
        container.add(desktop);
        if ("".equals(History.getToken())) {
            History.newItem(START.name().toLowerCase());
        } else {
            // Если пользователь обновил браузер....
            History.newItem(START.name().toLowerCase()); // Загружаем основной вид
            History.back(); // Возвращаем пользователя на последнее рабочее место
            History.fireCurrentHistoryState();
        }

    }
    @Override
    public void onValueChange(ValueChangeEvent<String> event) {
        Tokens token = null;
        try {
            token = Tokens.valueOf(event.getValue().toUpperCase());
        } catch (IllegalArgumentException e) {
            Window.alert("Page not found");
            History.newItem(START.name().toLowerCase());
        }
        switch (token) {
            case START:
                Presenter presenter = new HomePagePresenterImpl(CLIENT_FACTORY.getHomePageView());
                presenter.go(desktop);
                break;
            case PEOPLE:
                break;
        }

    }
}
