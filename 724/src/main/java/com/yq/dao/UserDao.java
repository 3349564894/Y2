package com.yq.dao;

import com.yq.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    User findUser(@Param("account") String account);

    List<User> findUserList();

    Integer changePassword(@Param("account") String account, @Param("newPassword") String newPassword);
}
