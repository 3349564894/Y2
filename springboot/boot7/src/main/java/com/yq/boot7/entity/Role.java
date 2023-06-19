package com.yq.boot7.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Table(name = "sys_role")
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long roleId;
    @Column(name = "role_name")
    private String roleName;
    @Column(name = "role_desc")
    private String roleDesc;
    @Column(name = "role_flag")
    private Integer roleFlag;
    @OneToMany(targetEntity = User.class,fetch = FetchType.LAZY,cascade = CascadeType.REMOVE,mappedBy = "role")
    private Set<User> userSet = new HashSet<>();

    public Role() {
    }

    public Role(Long roleId, String roleName, String roleDesc, Integer roleFlag, Set<User> userSet) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.roleDesc = roleDesc;
        this.roleFlag = roleFlag;
        this.userSet = userSet;
    }
}
