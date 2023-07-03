package com.yq.crm.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor

@TableName("sys_role")
public class Role implements Serializable {

    @TableId
    private Long roleId;
    private String roleName;
    private String roleDesc;
    private Integer roleFlag;
}
