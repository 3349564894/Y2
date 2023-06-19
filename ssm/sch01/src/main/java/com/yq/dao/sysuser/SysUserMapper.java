package com.yq.dao.sysuser;

import com.yq.entity.SysUser;

import java.util.List;

public interface SysUserMapper {

    /**
     * 统计用户数量方法
     *
     * @return
     */
    int count();

    /**
     * 查询用户列表
     *
     * @return
     */
    List<SysUser> getUserList();
}
