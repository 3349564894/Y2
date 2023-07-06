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

@TableName(value = "sys_right")
public class Right implements Serializable {

    @TableId
    private String rightCode;
    private String rightParentCode;
    private String rightType;
    private String rightText;
    private String rightUrl;
    private String rightTip;

    @TableField(exist = false)
    private Set<Role> roles = new HashSet<>(0);
}
