package com.yq.crm.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode

@TableName(value = "sys_user")
public class User implements Serializable {

    @TableId
    private Long usrId;
    private String usrName;
    private String usrPassword;
    private Long usrRoleId;
    private Integer usrFlag;

    @TableField(exist = false)
    private Role role;
}
