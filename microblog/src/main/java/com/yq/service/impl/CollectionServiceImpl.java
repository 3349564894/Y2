package com.yq.service.impl;

import com.yq.dao.CollectionDao;
import com.yq.entity.Blog;
import com.yq.entity.Collection;
import com.yq.service.CollectionService;
import com.yq.util.MyBatisUtil;
import com.yq.util.Page;
import org.apache.ibatis.session.SqlSession;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CollectionServiceImpl implements CollectionService {
    private SqlSession sqlSession = MyBatisUtil.createSqlSession();
    CollectionDao coll = sqlSession.getMapper(CollectionDao.class);

    @Override
    public int getCollectionCountByBid(int bid) throws SQLException {
        try {
            return coll.getCollectionCountByBid(bid);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            MyBatisUtil.closeSqlSession(sqlSession);
        }
    }

    @Override
    public int addCollection(Collection collection) throws SQLException {
        int result;
        try {
            if (coll.findCollection(collection.getUid(), collection.getBid()) == null) {
                result = coll.addCollection(collection);
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
    public Collection findCollection(int uid, int bid) throws SQLException {
        try {
            return coll.findCollection(uid, bid);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            MyBatisUtil.closeSqlSession(sqlSession);
        }
    }

    @Override
    public int deleteCollection(Collection collection) throws SQLException {
        int result;
        try {
            if (coll.findCollection(collection.getUid(), collection.getBid()) != null) {
                result = coll.deleteCollection(collection);
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
    public int deleteCollectionByBid(int bid) throws SQLException {
        int result;
        try {
            result = coll.deleteCollectionByBid(bid);

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
    public void getCollectionsByPage(int uid, String keyword, Page pageObj) throws SQLException {
        try {
            int totalCount = coll.getCollectionCountByUidAndKeyword(uid, keyword);
            pageObj.setTotalCount(totalCount); // 设置总数量并计算总页数
            if (totalCount > 0) {
                // 对末页进行控制
                if (pageObj.getCurrPageNo() > pageObj.getTotalPageCount())
                    pageObj.setCurrPageNo(pageObj.getTotalPageCount());
                // 进行分页查询
                List<Blog> blogList = coll.getCollectionsByPage(uid, keyword, pageObj.getOffset(), pageObj.getPageSize());
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
}
