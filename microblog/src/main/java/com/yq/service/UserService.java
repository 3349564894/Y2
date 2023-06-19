package com.yq.service;

import com.yq.entity.User;

import java.sql.SQLException;

public interface UserService {
    //查找某用户
    public User findUser(String uId, String password) throws SQLException;

    //更新用户信息
    public int updateUser(User user) throws SQLException;

    //查找用户Id是否已被使用
    public Boolean findUsers(String uId) throws SQLException;

    //新用户注册
    public int register(User user) throws SQLException;
}
