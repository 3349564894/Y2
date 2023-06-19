package com.yq.service.impl;

import com.yq.dao.UserDao;
import com.yq.dao.impl.UserDaoImpl;
import com.yq.entity.User;
import com.yq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {
    //    @Autowired
//    @Qualifier("userDao")
//    @Resource(name = "userDao")
    @Resource(type = UserDaoImpl.class)
    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }
}
