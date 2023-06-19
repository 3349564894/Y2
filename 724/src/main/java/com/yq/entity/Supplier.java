package com.yq.entity;

public class Supplier {
    int id;
    String supCode;
    String supName;
    String supDesc;
    String supContact;
    String supPhone;
    String supAddress;
    String supFax;
    int createdUserId;
    String createdTime;
    String updatedTime;
    int updatedUserId;

    public Supplier(int id, String supCode, String supName, String supDesc, String supContact, String supPhone, String supAddress, String supFax, int createdUserId, String createdTime, String updatedTime, int updatedUserId) {
        this.id = id;
        this.supCode = supCode;
        this.supName = supName;
        this.supDesc = supDesc;
        this.supContact = supContact;
        this.supPhone = supPhone;
        this.supAddress = supAddress;
        this.supFax = supFax;
        this.createdUserId = createdUserId;
        this.createdTime = createdTime;
        this.updatedTime = updatedTime;
        this.updatedUserId = updatedUserId;
    }

    public Supplier() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSupCode() {
        return supCode;
    }

    public void setSupCode(String supCode) {
        this.supCode = supCode;
    }

    public String getSupName() {
        return supName;
    }

    public void setSupName(String supName) {
        this.supName = supName;
    }

    public String getSupDesc() {
        return supDesc;
    }

    public void setSupDesc(String supDesc) {
        this.supDesc = supDesc;
    }

    public String getSupContact() {
        return supContact;
    }

    public void setSupContact(String supContact) {
        this.supContact = supContact;
    }

    public String getSupPhone() {
        return supPhone;
    }

    public void setSupPhone(String supPhone) {
        this.supPhone = supPhone;
    }

    public String getSupAddress() {
        return supAddress;
    }

    public void setSupAddress(String supAddress) {
        this.supAddress = supAddress;
    }

    public String getSupFax() {
        return supFax;
    }

    public void setSupFax(String supFax) {
        this.supFax = supFax;
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

    public String getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(String updatedTime) {
        this.updatedTime = updatedTime;
    }

    public int getUpdatedUserId() {
        return updatedUserId;
    }

    public void setUpdatedUserId(int updatedUserId) {
        this.updatedUserId = updatedUserId;
    }
}
