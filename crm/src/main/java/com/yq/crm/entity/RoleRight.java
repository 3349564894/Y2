package com.yq.crm.entity;

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

@TableName("sys_role_right")
public class RoleRight implements Serializable {
    @TableId
    private Long rfId;
    private Long rfRoleId;
    private String rfRightCode;

    @TableField(exist = false)
    private Set<Right> rights = new HashSet<>(0);
}
