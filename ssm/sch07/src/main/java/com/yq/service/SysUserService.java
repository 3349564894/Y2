package com.yq.service;

import com.yq.entity.SysUser;

import java.util.List;

public interface SysUserService {
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
    public boolean add(SysUser sysUser);
}
