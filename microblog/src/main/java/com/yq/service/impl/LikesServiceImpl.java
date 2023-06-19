package com.yq.service.impl;

import com.yq.dao.LikesDao;
import com.yq.entity.Blog;
import com.yq.entity.Likes;
import com.yq.service.LikesService;
import com.yq.util.DateUtil;
import com.yq.util.MyBatisUtil;
import com.yq.util.Page;
import org.apache.ibatis.session.SqlSession;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LikesServiceImpl implements LikesService {
    private SqlSession sqlSession = MyBatisUtil.createSqlSession();
    LikesDao likesDao = sqlSession.getMapper(LikesDao.class);

    @Override
    public int getLikeCountByBid(int bid) throws SQLException {
        try {
            return likesDao.getLikeCountByBid(bid);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            MyBatisUtil.closeSqlSession(sqlSession);
        }
    }

    @Override
    public int deleteLikesByBid(int bid) throws SQLException {
        int result;
        try {
            result = likesDao.deleteLikesByBid(bid);
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

    @Override
    public void getLikeBlogsByPage(int uid, String keyword, Page pageObj) throws SQLException {
        try {
            int totalCount = likesDao.getLikesCountByUidAndKeyword(uid, keyword);
            pageObj.setTotalCount(totalCount); // 设置总数量并计算总页数
            if (totalCount > 0) {
                // 对末页进行控制
                if (pageObj.getCurrPageNo() > pageObj.getTotalPageCount())
                    pageObj.setCurrPageNo(pageObj.getTotalPageCount());
                // 进行分页查询
                List<Blog> blogList = likesDao.getLikeBlogsByPage(uid, keyword, pageObj.getOffset(), pageObj.getPageSize());
                pageObj.setBlogsList(blogList);
            } else {
                pageObj.setCurrPageNo(0);
                pageObj.setBlogsList(new ArrayList<Blog>());
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            MyBatisUtil.closeSqlSession(sqlSession);
        }
    }

    @Override
    public int addLikes(Likes likes) throws SQLException {
        int result;
        try {
            if (likesDao.findLikes(likes.getUid(), likes.getBid()) == null) {
                result = likesDao.addLikes(likes, DateUtil.now());
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

    @Override
    public Likes findLikes(int uid, int bid) throws SQLException {
        try {
            return likesDao.findLikes(uid, bid);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            MyBatisUtil.closeSqlSession(sqlSession);
        }
    }

    @Override
    public int deleteLikes(Likes likes) throws SQLException {
        int result;
        try {
            if (likesDao.findLikes(likes.getUid(), likes.getBid()) != null) {
                result = likesDao.deleteLikes(likes);
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
