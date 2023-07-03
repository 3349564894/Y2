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

@TableName("sys_user")
public class User implements Serializable {

    @TableId
    private Long usrId;
    private String usrName;
    private String usrPassword;
    private Long usrRoleId;
    private Integer usrFlag;

    private Role role;
}
