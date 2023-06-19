package com.yq.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "sys_role")
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private int roleId;
    @Column(name = "role_name")
    private String roleName;
    @Column(name = "role_desc")
    private String roleDesc;
    @Column(name = "role_flag")
    private int roleFlag;

    public Role() {
    }

    public Role(int roleId, String roleName, String roleDesc, int roleFlag) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.roleDesc = roleDesc;
        this.roleFlag = roleFlag;
    }

    public Role(String roleName, String roleDesc, int roleFlag) {
        this.roleName = roleName;
        this.roleDesc = roleDesc;
        this.roleFlag = roleFlag;
    }
}
