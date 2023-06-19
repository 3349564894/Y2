package com.yq.crm.entity;

import lombok.Data;

@Data
public class Dict {
    private Long dict_id;
    private String dict_type;
    private String dict_item;
    private String dict_value;
    private Long dict_is_editable;

    public Dict() {
    }

    public Dict(Long dict_id, String dict_type, String dict_item, String dict_value, Long dict_is_editable) {
        this.dict_id = dict_id;
        this.dict_type = dict_type;
        this.dict_item = dict_item;
        this.dict_value = dict_value;
        this.dict_is_editable = dict_is_editable;
    }
}
