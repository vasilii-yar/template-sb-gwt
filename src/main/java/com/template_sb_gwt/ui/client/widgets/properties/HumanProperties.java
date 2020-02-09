package com.template_sb_gwt.ui.client.widgets.properties;

import com.google.gwt.editor.client.Editor;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;
import com.template_sb_gwt.ui.client.json.entities.HumanJson;

public interface HumanProperties extends PropertyAccess<HumanJson> {
    @Editor.Path("id")
    ModelKeyProvider<HumanJson> id();

    ValueProvider<HumanJson, String> name();
    ValueProvider<HumanJson, String> surname();
    ValueProvider<HumanJson, String> gender();
    ValueProvider<HumanJson, String> country();
}
