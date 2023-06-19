package com.yq.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@TableName("sys_role")
public class Role {
    //    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @TableId(type = IdType.AUTO)
    @TableField("role_Id")
    private Long role_Id;
    @TableField("role_name")
    private String role_name;
    @TableField("role_desc")
    private String role_desc;
    @TableField("role_flag")
    private Integer role_flag;

    public Role() {
    }

    public Long getRole_Id() {
        return role_Id;
    }

    public void setRole_Id(Long role_Id) {
        this.role_Id = role_Id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public String getRole_desc() {
        return role_desc;
    }

    public void setRole_desc(String role_desc) {
        this.role_desc = role_desc;
    }

    public Integer getRole_flag() {
        return role_flag;
    }

    public void setRole_flag(Integer role_flag) {
        this.role_flag = role_flag;
    }
}
