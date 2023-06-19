package dao;

import dao.impl.UserDaoImpl;

public class UserDaoFactory {
    public static UserDao getInstance() {
        return new UserDaoImpl();
    }
}
