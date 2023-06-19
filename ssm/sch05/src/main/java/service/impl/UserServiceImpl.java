package service.impl;

import dao.UserDao;
import dao.UserDaoFactory;
import entity.User;
import service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao dao;

    public void setDao(UserDao dao) {
        this.dao = dao;
    }

    @Override
    public void save(User user) {
        dao.save(user);
    }

}