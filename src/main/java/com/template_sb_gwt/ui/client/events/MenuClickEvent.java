package com.template_sb_gwt.ui.client.events;

import com.google.gwt.event.shared.GwtEvent;
import com.template_sb_gwt.ui.client.common.Tokens;

public class MenuClickEvent extends GwtEvent<MenuClickEventHandler> {
    public static Type<MenuClickEventHandler> TYPE = new Type<MenuClickEventHandler>();
    private Tokens token;
    public MenuClickEvent(Tokens token) {
        this.token = token;
    }

    public static Type<MenuClickEventHandler> getType() {
        return TYPE;
    }

    @Override
    public Type<MenuClickEventHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(MenuClickEventHandler handler) {
        handler.onClickMenu(this);
    }

    public Tokens getToken () {
        return token;
    }

}
