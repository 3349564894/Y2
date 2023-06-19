package com.yq.dao.impl;

import com.yq.dao.UserDao;
import com.yq.entity.User;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("userDao2")
public class UserDaoImpl2 implements UserDao {
    @Override
    public void save(User user) {
        System.out.println(123);
    }
}
