package com.yq.service;

import com.yq.pojo.User;

import java.util.List;

public interface UserService {
    User login(String usrName, String usrPassword);

    Integer add(User user);

    Integer remove(Long usrId);

    Integer updateUser(User user);

    User getUser(Long usrId);

    List<User> findUserList();
}
