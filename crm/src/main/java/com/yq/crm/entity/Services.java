package com.yq.crm.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("cst_service")
public class Services {
    private Long svrId;
    private String svrType;
    private String svrTitle;
    private String svrCustNo;
    private String svrCustName;
    private String svrStatus;
    private String svrRequest;
    private Long svrCreateId;
    private String svrCreateBy;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date svrCreateDate;
    private Long svrDueId;
    private String svrDueTo;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date svrDueDate;
    private String svrDeal;
    private Long svrDealId;
    private String svrDealBy;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date svrDealDate;
    private String svrResult;
    private Long svrSatisfy;
}
