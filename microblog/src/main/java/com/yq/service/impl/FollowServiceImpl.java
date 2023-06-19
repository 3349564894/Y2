package com.yq.service.impl;

import com.yq.dao.FollowDao;
import com.yq.entity.Follow;
import com.yq.entity.User;
import com.yq.service.FollowService;
import com.yq.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.sql.SQLException;
import java.util.List;

public class FollowServiceImpl implements FollowService {
    private SqlSession sqlSession = MyBatisUtil.createSqlSession();
    FollowDao followDao = sqlSession.getMapper(FollowDao.class);

    @Override
    public int getFollowedCount(int uId) throws SQLException {
        try {
            return followDao.getFollowedCount(uId);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            MyBatisUtil.closeSqlSession(sqlSession);
        }
    }

    @Override
    public int getFansCount(int uId) throws SQLException {
        try {
            return followDao.getFansCount(uId);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            MyBatisUtil.closeSqlSession(sqlSession);
        }
    }

    @Override
    public List<User> getFollowedByUidAndKeyword(int uId, String keyword) throws SQLException {
        try {
            return followDao.getFollowedByUidAndKeyword(uId, keyword);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            MyBatisUtil.closeSqlSession(sqlSession);
        }
    }

    @Override
    public List<User> getFansByUidAndKeyword(int uId, String keyword) throws SQLException {
        try {
            return followDao.getFansByUidAndKeyword(uId, keyword);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            MyBatisUtil.closeSqlSession(sqlSession);
        }
    }

    @Override
    public boolean isFollowed(int uId, int followedUid) throws SQLException {
        try {
            return followDao.isFollowed(uId, followedUid);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            MyBatisUtil.closeSqlSession(sqlSession);
        }
    }

    @Override
    public int addFollower(Follow follow) throws SQLException {
        int result = 0;
        try {
            if (!followDao.isFollowed(follow.getuId(), follow.getFollowerId())) {
                result = followDao.addFollower(follow);
            } else {
                result = -1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            MyBatisUtil.closeSqlSession(sqlSession);
        }
        return result;
    }

    @Override
    public int deleteFollower(Follow follow) throws SQLException {
        int result = 0;
        try {
            if (followDao.isFollowed(follow.getuId(), follow.getFollowerId())) {
                result = followDao.deleteFollower(follow);
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
