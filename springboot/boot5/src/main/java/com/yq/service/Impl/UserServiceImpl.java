package com.yq.service.Impl;

import com.yq.mapper.UserMapper;
import com.yq.pojo.User;
import com.yq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Integer add(User user) {
        return userMapper.add(user);
    }

    @Override
    public Integer remove(Long usrId) {
        return userMapper.remove(usrId);
    }

    @Override
    public Integer updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public User getUser(Long usrId) {
        return userMapper.getUser(usrId);
    }

    @Override
    public List<User> findUserList() {
        return userMapper.findUserList();
    }
}
