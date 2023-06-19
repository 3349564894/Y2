package com.yq.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "sys_user")
@Data
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usr_id")
    private Integer usrId;
    @Column(name = "usr_name")
    private String usrName;
    @Column(name = "usr_password")
    private String usrPassword;
    @Column(name = "usr_role_id")
    private Integer usrRoleId;
    @Column(name = "usr_flag")
    private Integer usrFlag;

    public User() {
    }

    public User(String usrName, String usrPassword, Integer usrRoleId, Integer usrFlag) {
        this.usrName = usrName;
        this.usrPassword = usrPassword;
        this.usrRoleId = usrRoleId;
        this.usrFlag = usrFlag;
    }

    public User(Integer usrId, String usrName, String usrPassword, Integer usrRoleId, Integer usrFlag) {
        this.usrId = usrId;
        this.usrName = usrName;
        this.usrPassword = usrPassword;
        this.usrRoleId = usrRoleId;
        this.usrFlag = usrFlag;
    }
}
