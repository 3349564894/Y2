package com.yq.crm.service.impl;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yq.crm.entity.User;
import com.yq.crm.mapper.UserMapper;
import com.yq.crm.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImp implements UserService{
    @Resource
    private UserMapper userMapper;

    @Override
    public Page<User> findUsers(Long usr_id, String usr_name) {
        return userMapper.findUsers(usr_id, usr_name);
    }

    @Override
    public User findUser(String user_name, String user_password) {
        return userMapper.findUser(user_name, user_password);
    }

    @Override
    public User findById(Long usr_id) {
        return userMapper.findById(usr_id);
    }

    @Override
    public Integer updateUser(User user) {
        return null;
    }

    @Override
    public Integer deleteUser() {
        return null;
    }

    @Override
    public Integer addUser() {
        return null;
    }

    public int insert(Object entity) {
        return 0;
    }

}
