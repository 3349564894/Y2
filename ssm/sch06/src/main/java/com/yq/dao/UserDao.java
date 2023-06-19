package com.yq.dao;

import com.yq.entity.User;

/**
 * 用户接口
 */
public interface UserDao {
    /**
     * 保存用户信息
     */
    public void save(User user);
}
