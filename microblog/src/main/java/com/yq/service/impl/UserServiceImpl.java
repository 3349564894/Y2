package com.yq.service.impl;

import com.yq.dao.UserDao;
import com.yq.entity.User;
import com.yq.service.UserService;
import com.yq.util.DateUtil;
import com.yq.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.sql.SQLException;

public class UserServiceImpl implements UserService {
    private SqlSession sqlSession = MyBatisUtil.createSqlSession();
    UserDao userDao = sqlSession.getMapper(UserDao.class);

    @Override
    public User findUser(String uId, String password) throws SQLException {
        try {
            return userDao.findUser(uId, password);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            MyBatisUtil.closeSqlSession(sqlSession);
        }
    }

    @Override
    public int updateUser(User user) throws SQLException {
        try {
            return userDao.updateUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            MyBatisUtil.closeSqlSession(sqlSession);
        }
    }

    @Override
    public Boolean findUsers(String uId) throws SQLException {
        try {
            User result = userDao.findUser(uId, DateUtil.now());
            if (result == null) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            MyBatisUtil.closeSqlSession(sqlSession);
        }
    }

    @Override
    public int register(User user) throws SQLException {
        int result;
        try {
            if (userDao.findUsers(user.getUserId()) == 0) {
                result = userDao.register(user, DateUtil.now());
            } else {
                result = -1;
            }
            sqlSession.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            if (sqlSession != null)
                sqlSession.rollback();
            throw e;
        } finally {
            MyBatisUtil.closeSqlSession(sqlSession);
        }
        return result;
    }
}
