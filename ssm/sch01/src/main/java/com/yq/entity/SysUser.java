package com.yq.entity;

import java.io.Serializable;

public class SysUser implements Serializable {
    private Integer id; //ID
    private String account; //账号
    private String password; //用户密码
    private String realName; //真实姓名
    private Integer sex; //性别
    private String birthday; //出生日期
    private String address; //地址
    private String phone; //电话
    private Integer roleId; //用户角色
    private Integer createUserId; //创建者
    private String createTime; //创建时间
    private Integer updatedUserId; //更新者
    private String updatedTime; //更新时间


    public SysUser() {
    }

    public SysUser(Integer id, String account, String password, String realName, Integer sex, String birthday, String address, String phone, Integer roleId, Integer createUserId, String createTime, Integer updatedUserId, String updatedTime) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.realName = realName;
        this.sex = sex;
        this.birthday = birthday;
        this.address = address;
        this.phone = phone;
        this.roleId = roleId;
        this.createUserId = createUserId;
        this.createTime = createTime;
        this.updatedUserId = updatedUserId;
        this.updatedTime = updatedTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getUpdatedUserId() {
        return updatedUserId;
    }

    public void setUpdatedUserId(Integer updatedUserId) {
        this.updatedUserId = updatedUserId;
    }

    public String getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(String updatedTime) {
        this.updatedTime = updatedTime;
    }
}
