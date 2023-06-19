package com.yq.crm.entity;

import lombok.Data;

@Data
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

    public Customer(String cust_no, String cust_name, String cust_region, Integer cust_manager_id, String cust_manager_name, Integer cust_level, String cust_level_label, Double cust_satisfy, Double cust_credit, Double cust_addr, Double cust_zip, Double cust_tel, Double cust_fax, Double cust_website, Double cust_licence_no, Double cust_chieftain, Double cust_bankroll, Double cust_turnover, Double cust_bank, Double cust_bank_account, Double cust_local_tax_no, Double cust_national_tax_no, Double cust_status) {
        this.cust_no = cust_no;
        this.cust_name = cust_name;
        this.cust_region = cust_region;
        this.cust_manager_id = cust_manager_id;
        this.cust_manager_name = cust_manager_name;
        this.cust_level = cust_level;
        this.cust_level_label = cust_level_label;
        this.cust_satisfy = cust_satisfy;
        this.cust_credit = cust_credit;
        this.cust_addr = cust_addr;
        this.cust_zip = cust_zip;
        this.cust_tel = cust_tel;
        this.cust_fax = cust_fax;
        this.cust_website = cust_website;
        this.cust_licence_no = cust_licence_no;
        this.cust_chieftain = cust_chieftain;
        this.cust_bankroll = cust_bankroll;
        this.cust_turnover = cust_turnover;
        this.cust_bank = cust_bank;
        this.cust_bank_account = cust_bank_account;
        this.cust_local_tax_no = cust_local_tax_no;
        this.cust_national_tax_no = cust_national_tax_no;
        this.cust_status = cust_status;
    }

    public Customer() {
    }
}
