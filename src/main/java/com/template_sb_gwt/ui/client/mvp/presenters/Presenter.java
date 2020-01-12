package com.template_sb_gwt.ui.client.mvp.presenters;

import com.google.gwt.user.client.ui.HasWidgets;

public interface Presenter {
    void go(final HasWidgets container);
    void bind();
}
