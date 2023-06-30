package com.yq.crm.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("cst_lost")
public class Lost {
    private Integer lst_id;
    private String lst_cust_no;
    private String lst_cust_name;
    private Integer lst_cust_manager_id;
    private String lst_cust_manager_name;
    private String lst_last_order_date;
    private String lst_lost_date;
    private String lst_delay;
    private String lst_reason;
    private String lst_status;
}
