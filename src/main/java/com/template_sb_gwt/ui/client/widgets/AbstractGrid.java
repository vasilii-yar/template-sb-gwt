package com.template_sb_gwt.ui.client.widgets;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.google.web.bindery.autobean.shared.AutoBeanFactory;
import com.sencha.gxt.data.shared.loader.JsonReader;
import com.sencha.gxt.data.shared.loader.ListLoadResult;
import com.sencha.gxt.data.shared.loader.ListLoadResultBean;
import com.template_sb_gwt.ui.client.json.GridRecordResult;
import com.template_sb_gwt.ui.client.json.entities.HumanJson;

public abstract class AbstractGrid<T, R extends GridRecordResult> implements IsWidget {

    public class DataRecordJsonReader<T, R extends GridRecordResult> extends JsonReader<ListLoadResult<T>, R> {
        public DataRecordJsonReader(AutoBeanFactory factory, Class<R> rootBeanType) {
            super(factory, rootBeanType);
        }

        @Override
        protected ListLoadResult<T> createReturnData(Object loadConfig, R incomingData) {
            return (ListLoadResult<T>) new ListLoadResultBean<HumanJson>(incomingData.getRecords());
        }
    }

    public abstract Widget asWidget();
}
