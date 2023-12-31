package com.yq.crm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor

@TableName(value = "sys_role")
public class Role implements Serializable {

    @TableId
    private Long roleId;
    private String roleName;
    private String roleDesc;
    private Integer roleFlag;

    @TableField(exist = false)
    private Set<RoleRight> roleRights = new HashSet<>(0);
}
