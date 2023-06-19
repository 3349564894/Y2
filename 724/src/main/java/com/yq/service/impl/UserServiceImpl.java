package com.yq.service.impl;

import com.yq.dao.UserDao;
import com.yq.entity.User;
import com.yq.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("UserService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public User findUser(String account) {
        return userDao.findUser(account);
    }

    @Override
    public List<User> findUserList() {
        return userDao.findUserList();
    }

    @Override
    public Integer changePassword(String account, String newPassword) {
        return userDao.changePassword(account, newPassword);
    }
}
