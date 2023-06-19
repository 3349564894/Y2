package com.yq.crm.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("sys_user")
public class User {
    private Long usr_id;
    private String usr_name;
    private String usr_password;
    private Long usr_role_id;
    private Integer usr_flag;
    private String usr_role_name;

    public User() {
    }

    public User(Long usr_id, String usr_name, String usr_password, Long usr_role_id, Integer usr_flag) {
        this.usr_id = usr_id;
        this.usr_name = usr_name;
        this.usr_password = usr_password;
        this.usr_role_id = usr_role_id;
        this.usr_flag = usr_flag;
    }
}
