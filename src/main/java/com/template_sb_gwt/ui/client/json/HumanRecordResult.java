package com.template_sb_gwt.ui.client.json;

import com.template_sb_gwt.ui.client.json.entities.HumanJson;

import java.util.List;

public interface HumanRecordResult extends GridRecordResult {
    List<HumanJson> getRecords();
}
