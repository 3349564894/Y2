package dao.impl;

import dao.UserDao;
import entity.User;

public class UserDaoImpl implements UserDao {
    @Override
    public void save(User user) {
        System.out.println("保存信息到数据库");
    }
}
