package com.yq.dao.impl;

import com.yq.dao.UserDao;
import com.yq.entity.User;
import org.springframework.stereotype.Component;

@Component("userDao")
public class UserDaoImpl implements UserDao {
    @Override
    public void save(User user) {
        System.out.println("保存用户信息到数据库");
    }
}
