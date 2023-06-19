package com.yq.service.impl;

import com.yq.dao.CommentDao;
import com.yq.entity.Comment;
import com.yq.service.CommentService;
import com.yq.util.DatabaseUtil;
import com.yq.util.DateUtil;
import com.yq.util.MyBatisUtil;
import com.yq.util.Page;
import org.apache.ibatis.session.SqlSession;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommentServiceImpl implements CommentService {
    private SqlSession sqlSession = MyBatisUtil.createSqlSession();
    CommentDao commentDao = sqlSession.getMapper(CommentDao.class);

    @Override
    public int getCommentCountByBid(int bid) throws SQLException {
        Connection conn = null;
        try {
            conn = DatabaseUtil.getConnection();
            return commentDao.getCommentCountByBid(bid);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            MyBatisUtil.closeSqlSession(sqlSession);
        }
    }

    @Override
    public List<Comment> getCommentsByBid(int bid) throws SQLException {
        try {
            return commentDao.getCommentsByBid(bid);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            MyBatisUtil.closeSqlSession(sqlSession);
        }
    }

    @Override
    public int addComment(Comment comment) throws SQLException {
        int result;
        try {
            result = commentDao.addComment(comment, DateUtil.now());

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
    public int deleteCommentsByBid(int bid) throws SQLException {
        int result;
        try {
            result = commentDao.deleteCommentsByBid(bid);
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
    public void getCommentsByPage(int bid, Page pageObj) throws SQLException {
        try {
            int totalCount = commentDao.getCommentCountByBid(bid);
            pageObj.setTotalCount(totalCount); // 设置总数量并计算总页数
            if (totalCount > 0) {
                // 对末页进行控制
                if (pageObj.getCurrPageNo() > pageObj.getTotalPageCount())
                    pageObj.setCurrPageNo(pageObj.getTotalPageCount());
                // 进行分页查询
                List<Comment> commentsList = commentDao.getCommentsByPage(bid, pageObj.getOffset(), pageObj.getPageSize());
                pageObj.setCommentList(commentsList);
            } else {
                pageObj.setCurrPageNo(0);
                pageObj.setCommentList(new ArrayList<Comment>());
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            MyBatisUtil.closeSqlSession(sqlSession);
        }
    }

}
