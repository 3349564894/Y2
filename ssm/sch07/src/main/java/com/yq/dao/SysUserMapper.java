package com.yq.dao;

import com.yq.entity.SysUser;

import java.util.*;

public interface SysUserMapper {
    /**
     * 查询所有用户
     *
     * @return
     */
    public List<SysUser> findUser();

    /**
     * 新增用户
     *
     * @param sysUser
     * @return
     */
    public Integer add(SysUser sysUser);
}
