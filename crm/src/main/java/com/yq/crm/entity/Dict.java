package com.yq.crm.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("bas_dict")
public class Dict {
    private Long dict_id;
    private String dict_type;
    private String dict_item;
    private String dict_value;
    private Long dict_is_editable;
}
