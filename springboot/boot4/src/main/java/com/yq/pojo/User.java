package com.yq.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

import javax.persistence.*;

@Data
@Entity
@TableName("sys_user")
public class User implements Serializable {
    //    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @TableId(type = IdType.AUTO)
    @Id
//    @TableField("usr_id")
    private Long usrId;
    //    @TableField("usr_name")
    private String usrName;
    //    @TableField("usr_password")
    private String usrPassword;
    //    @TableField("usr_role_id")
    private Long usrRoleId;
    //    @TableField("usr_flag")
    private Integer usrFlag;

    public User() {
    }

    public User(String usrName, String usrPassword, Long usrRoleId, Integer usrFlag) {
        this.usrName = usrName;
        this.usrPassword = usrPassword;
        this.usrRoleId = usrRoleId;
        this.usrFlag = usrFlag;
    }

    public User(Long usrId, String usrName, String usrPassword, Long usrRoleId, Integer usrFlag) {
        this.usrId = usrId;
        this.usrName = usrName;
        this.usrPassword = usrPassword;
        this.usrRoleId = usrRoleId;
        this.usrFlag = usrFlag;
    }
}
