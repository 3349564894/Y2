package com.yq.entity;

public class Role {
    int id;
    String code;
    String roleName;
    int createdUserId;
    String createdTime;
    int updatedUserId;
    String updatedTime;

    public Role(int id, String code, String roleName, int createdUserId, String createdTime, int updatedUserId, String updatedTime) {
        this.id = id;
        this.code = code;
        this.roleName = roleName;
        this.createdUserId = createdUserId;
        this.createdTime = createdTime;
        this.updatedUserId = updatedUserId;
        this.updatedTime = updatedTime;
    }

    public Role() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
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
