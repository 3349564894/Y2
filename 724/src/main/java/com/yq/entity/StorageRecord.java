package com.yq.entity;

public class StorageRecord {
    int id;
    String srCode;
    String goodsName;
    String goodsDesc;
    String goodsUnit;
    double goodsCount;
    double totalAmount;
    int payStatus;
    int createdUserId;
    String createdTime;
    int updatedUserId;
    String updatedTime;
    int supplierId;

    public StorageRecord(int id, String srCode, String goodsName, String goodsDesc, String goodsUnit, double goodsCount, double totalAmount, int payStatus, int createdUserId, String createdTime, int updatedUserId, String updatedTime, int supplierId) {
        this.id = id;
        this.srCode = srCode;
        this.goodsName = goodsName;
        this.goodsDesc = goodsDesc;
        this.goodsUnit = goodsUnit;
        this.goodsCount = goodsCount;
        this.totalAmount = totalAmount;
        this.payStatus = payStatus;
        this.createdUserId = createdUserId;
        this.createdTime = createdTime;
        this.updatedUserId = updatedUserId;
        this.updatedTime = updatedTime;
        this.supplierId = supplierId;
    }

    public StorageRecord() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSrCode() {
        return srCode;
    }

    public void setSrCode(String srCode) {
        this.srCode = srCode;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc;
    }

    public String getGoodsUnit() {
        return goodsUnit;
    }

    public void setGoodsUnit(String goodsUnit) {
        this.goodsUnit = goodsUnit;
    }

    public double getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(double goodsCount) {
        this.goodsCount = goodsCount;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(int payStatus) {
        this.payStatus = payStatus;
    }

    public int getCreatedUserId() {
        return createdUserId;
    }

    public void setCreatedUserId(int createdUserId) {
        this.createdUserId = createdUserId;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public int getUpdatedUserId() {
        return updatedUserId;
    }

    public void setUpdatedUserId(int updatedUserId) {
        this.updatedUserId = updatedUserId;
    }

    public String getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(String updatedTime) {
        this.updatedTime = updatedTime;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }
}
