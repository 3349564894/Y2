package com.yq.boot7.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Table(name = "sys_user")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usr_id")
    private Long usrId;
    @Column(name = "usr_name")
    private String usrName;
    @Column(name = "usr_password")
    private String usrPassword;
    @ManyToOne(targetEntity = Role.class)
    @JoinColumn(name = "usr_role_id")
    private Role role;
    @Column(name = "usr_flag")
    private Integer usrFlag;
    public User() {
    }

    public User(Long usrId, String usrName, String usrPassword, Role role, Integer usrFlag) {
        this.usrId = usrId;
        this.usrName = usrName;
        this.usrPassword = usrPassword;
        this.role = role;
        this.usrFlag = usrFlag;
    }
}
