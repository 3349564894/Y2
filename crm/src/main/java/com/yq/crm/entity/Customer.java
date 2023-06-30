package com.yq.crm.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("cst_customer")
public class Customer {
    private String cust_no;
    private String cust_name;
    private String cust_region;
    private Integer cust_manager_id;
    private String cust_manager_name;
    private Integer cust_level;
    private String cust_level_label;
    private Double cust_satisfy;
    private Double cust_credit;
    private Double cust_addr;
    private Double cust_zip;
    private Double cust_tel;
    private Double cust_fax;
    private Double cust_website;
    private Double cust_licence_no;
    private Double cust_chieftain;
    private Double cust_bankroll;
    private Double cust_turnover;
    private Double cust_bank;
    private Double cust_bank_account;
    private Double cust_local_tax_no;
    private Double cust_national_tax_no;
    private Double cust_status;
}
