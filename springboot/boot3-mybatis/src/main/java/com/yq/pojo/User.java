package com.yq.pojo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "sys_user")
public class User implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "usr_id")
    private Long usr_id;
    @Column(name = "usr_name")
    private String usr_name;
    @Column(name = "usr_password")
    private String usr_password;
    @Column(name = "usr_role_id")
    private Long usr_role_id;
    @Column(name = "usr_flag")
    private Integer usr_flag;

    public User() {
    }

    public User(String usrName, String usrPassword, Long usrRoleId, Integer usrFlag) {
        this.usr_name = usrName;
        this.usr_password = usrPassword;
        this.usr_role_id = usrRoleId;
        this.usr_flag = usrFlag;
    }

    public User(Long usrId, String usrName, String usrPassword, Long usrRoleId, Integer usrFlag) {
        this.usr_id = usrId;
        this.usr_name = usrName;
        this.usr_password = usrPassword;
        this.usr_role_id = usrRoleId;
        this.usr_flag = usrFlag;
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
}
