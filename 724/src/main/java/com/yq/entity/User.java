package com.yq.entity;

public class User {
    int id;
    String account;
    String realName;
    String password;
    int sex;
    String birthday;
    String phone;
    String address;
    int roleId;
    int createdUserId;
    String createdTime;
    int updatedUserId;
    String updatedTime;

    public User() {
    }

    public User(int id, String account, String realName, String password, int sex, String birthday, String phone, String address, int roleId, int createdUserId, String createdTime, int updatedUserId, String updatedTime) {
        this.id = id;
        this.account = account;
        this.realName = realName;
        this.password = password;
        this.sex = sex;
        this.birthday = birthday;
        this.phone = phone;
        this.address = address;
        this.roleId = roleId;
        this.createdUserId = createdUserId;
        this.createdTime = createdTime;
        this.updatedUserId = updatedUserId;
        this.updatedTime = updatedTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
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
}
