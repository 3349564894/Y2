package com.yq.boot8.entity;

import java.io.Serializable;

public class User implements Serializable {
    private Long usr_id;
    private String usr_name;
    private String usr_password;
    private Long usr_role_id;
    private Integer usr_flag;
    private String usr_role_name;

    public User() {
    }

    public User(Long usr_id, String usr_name, String usr_password, Long usr_role_id, Integer usr_flag) {
        this.usr_id = usr_id;
        this.usr_name = usr_name;
        this.usr_password = usr_password;
        this.usr_role_id = usr_role_id;
        this.usr_flag = usr_flag;
    }

    public Long getUsr_id() {
        return usr_id;
    }

    public void setUsr_id(Long usr_id) {
        this.usr_id = usr_id;
    }

    public String getUsr_name() {
        return usr_name;
    }

    public void setUsr_name(String usr_name) {
        this.usr_name = usr_name;
    }

    public String getUsr_password() {
        return usr_password;
    }

    public void setUsr_password(String usr_password) {
        this.usr_password = usr_password;
    }

    public Long getUsr_role_id() {
        return usr_role_id;
    }

    public void setUsr_role_id(Long usr_role_id) {
        this.usr_role_id = usr_role_id;
    }

    public Integer getUsr_flag() {
        return usr_flag;
    }

    public void setUsr_flag(Integer usr_flag) {
        this.usr_flag = usr_flag;
    }

    public String getUsr_role_name() {
        return usr_role_name;
    }

    public void setUsr_role_name(String usr_role_name) {
        this.usr_role_name = usr_role_name;
    }
}
