package com.yq.crm.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
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

    public Services() {
    }

    public Services(Long svrId, String svrType, String svrTitle, String svrCustNo, String svrCustName, String svrStatus, String svrRequest, Long svrCreateId, String svrCreateBy, Date svrCreateDate, Long svrDueId, String svrDueTo, Date svrDueDate, String svrDeal, Long svrDealId, String svrDealBy, Date svrDealDate, String svrResult, Long svrSatisfy) {
        this.svrId = svrId;
        this.svrType = svrType;
        this.svrTitle = svrTitle;
        this.svrCustNo = svrCustNo;
        this.svrCustName = svrCustName;
        this.svrStatus = svrStatus;
        this.svrRequest = svrRequest;
        this.svrCreateId = svrCreateId;
        this.svrCreateBy = svrCreateBy;
        this.svrCreateDate = svrCreateDate;
        this.svrDueId = svrDueId;
        this.svrDueTo = svrDueTo;
        this.svrDueDate = svrDueDate;
        this.svrDeal = svrDeal;
        this.svrDealId = svrDealId;
        this.svrDealBy = svrDealBy;
        this.svrDealDate = svrDealDate;
        this.svrResult = svrResult;
        this.svrSatisfy = svrSatisfy;
    }
}
