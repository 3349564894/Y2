package com.yq.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "sys_role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Integer roleId;
    @Column(name = "role_name")
    private String roleName;
    @Column(name = "role_desc")
    private String roleDesc;
    @Column(name = "role_flag")
    private Integer roleFlag;
    @OneToMany(targetEntity = User.class, fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, mappedBy = "role")
    private Set<User> userSet = new HashSet<>();

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

    public Role(String roleName, String roleDesc, int roleFlag, Set<User> userSet) {
        this.roleName = roleName;
        this.roleDesc = roleDesc;
        this.roleFlag = roleFlag;
        this.userSet = userSet;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public Integer getRoleFlag() {
        return roleFlag;
    }

    public void setRoleFlag(Integer roleFlag) {
        this.roleFlag = roleFlag;
    }

    public Set<User> getUserSet() {
        return userSet;
    }

    public void setUserSet(Set<User> userSet) {
        this.userSet = userSet;
    }
}
