package com.yq.crm.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import groovy.transform.Field;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("sal_chance")
public class Chance {
    @TableId
    @TableField("chc_id")
    private Long chcId;
    @TableField("chc_source")
    private String chcSource;
    @TableField("chc_cust_name")
    private String chcCustName;
    @TableField("chc_title")
    private String chcTitle;
    @TableField("chc_rate")
    private Integer chcRate;
    @TableField("chc_linkman")
    private String chcLinkman;
    @TableField("chc_tel")
    private String chcTel;
    @TableField("chc_desc")
    private String chcDesc;
    @TableField("chc_create_id")
    private Long chcCreateId;
    @TableField("chc_create_by")
    private String chcCreateBy;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    @TableField("chc_create_date")
    private Date chcCreateDate;
    @TableField("chc_due_id")
    private Long chcDueId;
    @TableField("chc_due_to")
    private String chcDueTo;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    @TableField("chc_due_data")
    private Date chcDueData;
    @TableField("chc_status")
    private Integer chcStatus;
}
