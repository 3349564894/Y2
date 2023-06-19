package com.yq.service;

import com.yq.pojo.User;

import java.util.List;

public interface UserService {
    User login(String usrName, String usrPassword);

    Integer addUser(User user);

    void remove(Long usrId);

    User updateUser(User user);

    User getUser(Long usrId);

    List<User> findAllUsers();
}
