package com.yq.dao;

import com.yq.dao.impl.UserDaoImpl;

public class UserDaoFactory {
    public static UserDaoImpl getInstance() {
        return new UserDaoImpl();
    }
}
