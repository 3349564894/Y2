package com.yq.service;

import com.yq.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    User findUser(@Param("account") String account);

    List<User> findUserList();

    Integer changePassword(@Param("account") String account, @Param("newPassword") String newPassword);
}
