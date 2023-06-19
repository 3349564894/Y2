package com.yq.crm.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yq.crm.entity.User;


public interface UserService {
    Page<User> findUsers( Long usr_id,  String usr_name);

    User findUser( String userName, String userPassword);

    User findById(Long usr_id);

    Integer updateUser(User user);

    Integer deleteUser();

    Integer addUser();
}
