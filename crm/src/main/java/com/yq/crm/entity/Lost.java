package com.yq.crm.entity;

import lombok.Data;

@Data
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

    public Lost() {
    }

    public Lost(Integer lst_id, String lst_cust_no, String lst_cust_name, Integer lst_cust_manager_id, String lst_cust_manager_name, String lst_last_order_date, String lst_lost_date, String lst_delay, String lst_reason, String lst_status) {
        this.lst_id = lst_id;
        this.lst_cust_no = lst_cust_no;
        this.lst_cust_name = lst_cust_name;
        this.lst_cust_manager_id = lst_cust_manager_id;
        this.lst_cust_manager_name = lst_cust_manager_name;
        this.lst_last_order_date = lst_last_order_date;
        this.lst_lost_date = lst_lost_date;
        this.lst_delay = lst_delay;
        this.lst_reason = lst_reason;
        this.lst_status = lst_status;
    }
}
