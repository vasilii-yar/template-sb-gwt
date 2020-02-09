package com.template_sb_gwt.ui.client.widgets;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.user.client.ui.Widget;
import com.google.web.bindery.autobean.shared.AutoBean;
import com.google.web.bindery.autobean.shared.AutoBeanFactory;
import com.sencha.gxt.data.client.loader.HttpProxy;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.loader.ListLoadConfig;
import com.sencha.gxt.data.shared.loader.ListLoadResult;
import com.sencha.gxt.data.shared.loader.ListLoader;
import com.sencha.gxt.data.shared.loader.LoadResultListStoreBinding;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.BoxLayoutContainer;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;
import com.sencha.gxt.widget.core.client.grid.RowNumberer;
import com.template_sb_gwt.ui.client.json.HumanRecordResult;
import com.template_sb_gwt.ui.client.json.entities.HumanJson;
import com.template_sb_gwt.ui.client.widgets.properties.HumanProperties;

import java.util.ArrayList;
import java.util.List;

public class HumansGrid extends AbstractGrid<HumanJson, HumanRecordResult> {
    private static final HumanProperties PROPS = GWT.create(HumanProperties.class);

    private final HttpProxy<ListLoadConfig> proxy;
    private final ListStore<HumanJson> store = new ListStore<>(PROPS.id());
    private ContentPanel panel;

    public interface HumanAutoBeanFactory extends AutoBeanFactory {
        AutoBean<HumanRecordResult> items();

        AutoBean<ListLoadConfig> loadConfig();
    }

    public HumansGrid(HttpProxy<ListLoadConfig> proxy) {
        this.proxy = proxy;
    }

    @Override
    public Widget asWidget() {
        if (panel == null) {
            HumanAutoBeanFactory factory = GWT.create(HumanAutoBeanFactory.class);
            RowNumberer<HumanJson> rn = new RowNumberer<>();
            ColumnModel<HumanJson> cm = getGridColumnModel(rn);

            DataRecordJsonReader jsonReader = new DataRecordJsonReader(factory, HumanRecordResult.class);
            ListLoader<ListLoadConfig, ListLoadResult<HumanJson>> loader = new ListLoader<>(proxy, jsonReader);
            loader.useLoadConfig(factory.create(ListLoadConfig.class).as());

            loader.addLoadHandler(new LoadResultListStoreBinding<ListLoadConfig, HumanJson, ListLoadResult<HumanJson>>(store));

            final Grid<HumanJson> grid = new Grid<HumanJson>(store, cm) {
                @Override
                protected void onAfterFirstAttach() {
                    super.onAfterFirstAttach();
                    Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand() {
                        @Override
                        public void execute() {
                            loader.load();
                        }
                    });
                }
            };

            grid.setLoader(loader);
            grid.setLoadMask(true);
            grid.getView().setStripeRows(true);
            grid.getView().setColumnLines(true);
            grid.getView().setForceFit(true);
            grid.setColumnReordering(true);

            rn.initPlugin(grid);

            panel = new ContentPanel();
            panel.setHeading("Humans grid");
            panel.add(grid);
            panel.addButton(new TextButton("Get data", new SelectEvent.SelectHandler() {
                @Override
                public void onSelect(SelectEvent event) {
                    loader.load();
                }
            }));

            panel.setButtonAlign(BoxLayoutContainer.BoxLayoutPack.CENTER);
        }
        return panel;
    }

    private ColumnModel<HumanJson> getGridColumnModel(RowNumberer<HumanJson> rn) {
        rn.setHeader("№");

        ColumnConfig<HumanJson, String> name = new ColumnConfig<>(PROPS.name(), 100, "Name");
        ColumnConfig<HumanJson, String> surname = new ColumnConfig<>(PROPS.surname(), 100, "Surname");
        ColumnConfig<HumanJson, String> gender = new ColumnConfig<>(PROPS.gender(), 100, "Gender");
        ColumnConfig<HumanJson, String> country = new ColumnConfig<>(PROPS.country(), 100, "Country");

        List<ColumnConfig<HumanJson, ?>> columns = new ArrayList<>();
        columns.add(rn);
        columns.add(name);
        columns.add(surname);
        columns.add(gender);
        columns.add(country);

        ColumnModel<HumanJson> columnModel = new ColumnModel<>(columns);
        return columnModel;
    }

}
