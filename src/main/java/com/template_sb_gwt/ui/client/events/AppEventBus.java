package com.template_sb_gwt.ui.client.events;

import com.google.gwt.event.shared.SimpleEventBus;

public final class AppEventBus extends SimpleEventBus {

    private AppEventBus() {

    }

    public static AppEventBus getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static final AppEventBus INSTANCE = new AppEventBus();
        private SingletonHolder() {

        }

    }
}
