package com.yq.crm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yq.crm.entity.User;
import com.yq.crm.mapper.UserMapper;
import com.yq.crm.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.awt.print.Pageable;
import java.sql.Wrapper;
import java.util.List;

@Service
public class UserServiceImp implements UserService{

    @Resource
    private UserMapper userMapper;

    @Override
    public Page<User> findUsers(Page page, QueryWrapper wrapper) {
        return userMapper.selectPage(page, wrapper);
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
    public User findByName(String usrName) {
        return userMapper.findByName(usrName);
    }

    @Override
    public Integer updateUser(User user) {
        return null;
    }

    @Override
    public Integer deleteUser(Long usrId) {
        return userMapper.deleteUser(usrId);
    }

    @Override
    public Integer addUser(User user) {
        return userMapper.addUser(user);
    }

}
