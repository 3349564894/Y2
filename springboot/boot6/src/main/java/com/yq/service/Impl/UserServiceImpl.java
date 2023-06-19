package com.yq.service.Impl;

import com.yq.mapper.UserMapper;
import com.yq.pojo.User;
import com.yq.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User login(String usrName, String usrPassword) {
        return userMapper.login(usrName, usrPassword);
    }

    @Override
    public Integer addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public void remove(Long usrId) {
        userMapper.remove(usrId);
    }

    @Override
    public User updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public User getUser(Long usrId) {
        return userMapper.getUser(usrId);
    }

    @Override
    public List<User> findAllUsers() {
        return userMapper.findAllUsers();
    }
}
