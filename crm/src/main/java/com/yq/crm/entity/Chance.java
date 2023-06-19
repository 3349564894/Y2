package com.yq.crm.entity;

import groovy.transform.Field;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class Chance {
    private Integer chc_id;
    private String chc_source;
    private String chc_cust_name;
    private String chc_title;
    private Integer chc_rate;
    private String chc_linkman;
    private String chc_tel;
    private String chc_desc;
    private Integer chc_create_id;
    private String chc_create_by;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    private Date chc_create_date;
    private Integer chc_due_id;
    private String chc_due_to;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    private Date chc_due_data;
    private Integer chc_status;

    public Chance() {
    }

    public Chance(Integer chc_id, String chc_source, String chc_cust_name, String chc_title, Integer chc_rate, String chc_linkman, String chc_tel, String chc_desc, Integer chc_create_id, String chc_create_by, Date chc_create_date, Integer chc_due_id, String chc_due_to, Date chc_due_data, Integer chc_status) {
        this.chc_id = chc_id;
        this.chc_source = chc_source;
        this.chc_cust_name = chc_cust_name;
        this.chc_title = chc_title;
        this.chc_rate = chc_rate;
        this.chc_linkman = chc_linkman;
        this.chc_tel = chc_tel;
        this.chc_desc = chc_desc;
        this.chc_create_id = chc_create_id;
        this.chc_create_by = chc_create_by;
        this.chc_create_date = chc_create_date;
        this.chc_due_id = chc_due_id;
        this.chc_due_to = chc_due_to;
        this.chc_due_data = chc_due_data;
        this.chc_status = chc_status;
    }
}
