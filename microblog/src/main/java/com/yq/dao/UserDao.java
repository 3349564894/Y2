package com.yq.dao;

import com.yq.entity.User;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;

public interface UserDao {
    //查找用户是否存在
    public User findUser(@Param("userId") String userId, @Param("password") String password) throws SQLException;

    //更新用户头像
    public int updateUser(User user) throws SQLException;

    //查找用户Id是否已被使用
    public int findUsers(String userId) throws SQLException;

    //注册新用户
    public int register(User user, @Param("now") String now) throws SQLException;
}
