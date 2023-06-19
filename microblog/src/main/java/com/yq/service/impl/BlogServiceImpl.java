package com.yq.service.impl;

import com.yq.dao.BlogDao;
import com.yq.entity.Blog;
import com.yq.service.BlogService;
import com.yq.service.CollectionService;
import com.yq.service.CommentService;
import com.yq.service.LikesService;
import com.yq.util.DateUtil;
import com.yq.util.MyBatisUtil;
import com.yq.util.Page;
import org.apache.ibatis.session.SqlSession;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BlogServiceImpl implements BlogService {
    private SqlSession sqlSession = MyBatisUtil.createSqlSession();
    BlogDao blogDao = sqlSession.getMapper(BlogDao.class);

    @Override
    public Blog getBlogById(int id) throws SQLException {
        try {
            return blogDao.findBlogById(id);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            MyBatisUtil.closeSqlSession(sqlSession);
        }
    }

    @Override
    public int getForwardCountByBid(int bid) throws SQLException {
        try {
            return blogDao.getForwardCountByBid(bid);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            MyBatisUtil.closeSqlSession(sqlSession);
        }
    }

    @Override
    public int deleteBlog(int id) throws SQLException {
        int result = 0;
        try {
            //删除该条微博的所有评论
            sqlSession.getMapper(CommentService.class).deleteCommentsByBid(id);
            //删除该条微博的所有收藏
            sqlSession.getMapper(CollectionService.class).deleteCollectionByBid(id);
            //删除该条微博的所有点赞
            sqlSession.getMapper(LikesService.class).deleteLikesByBid(id);
            //删除该条微博
            result = blogDao.deleteBlog(id);
            sqlSession.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            if (sqlSession != null) {
                sqlSession.rollback();
            }
            throw e;
        } finally {
            MyBatisUtil.closeSqlSession(sqlSession);
        }
        return result;
    }

    @Override
    public int getBlogCount(int uId) throws SQLException {
        try {
            return blogDao.getBlogCount(uId);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            MyBatisUtil.closeSqlSession(sqlSession);
        }
    }

    @Override
    public void getAllBlogsByPage(int uId, String keyword, Page pageObj) throws SQLException {
        try {
            int totalCount = blogDao.getAllBlogsCount(uId, keyword);
            pageObj.setTotalCount(totalCount); // 设置总数量并计算总页数
            if (totalCount > 0) {
                // 对末页进行控制
                if (pageObj.getCurrPageNo() > pageObj.getTotalPageCount())
                    pageObj.setCurrPageNo(pageObj.getTotalPageCount());
                // 进行分页查询
                List<Blog> blogList = blogDao.getAllBlogsByPage(uId, keyword, pageObj.getOffset(), pageObj.getPageSize());
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
    public int addNewBlog(Blog blog) throws SQLException {
        int result;
        try {
            return blogDao.addNewBlog(blog, DateUtil.now());
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            MyBatisUtil.closeSqlSession(sqlSession);
        }
    }


    @Override
    public void getPopBlogsByPage(int uId, String keyword, Page pageObj) throws SQLException {
        try {
            int totalCount = blogDao.getPopBlogsCount(uId, keyword);
            pageObj.setTotalCount(totalCount); // 设置总数量并计算总页数
            if (totalCount > 0) {
                // 对末页进行控制
                if (pageObj.getCurrPageNo() > pageObj.getTotalPageCount())
                    pageObj.setCurrPageNo(pageObj.getTotalPageCount());
                // 进行分页查询
                List<Blog> blogList = blogDao.getPopBlogsByPage(uId, keyword, pageObj.getOffset(), pageObj.getPageSize());
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
    public void getMyBlogsByPage(int uId, String keyword, Page pageObj) throws SQLException {
        try {
            int totalCount = blogDao.getBlogCountByUidAndKeyword(uId, keyword);
            pageObj.setTotalCount(totalCount); // 设置总数量并计算总页数
            if (totalCount > 0) {
                // 对末页进行控制
                if (pageObj.getCurrPageNo() > pageObj.getTotalPageCount())
                    pageObj.setCurrPageNo(pageObj.getTotalPageCount());
                // 进行分页查询
                List<Blog> blogList = blogDao.getMyBlogsByPage(uId, keyword, pageObj.getOffset(), pageObj.getPageSize());
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
    public int forwardBlog(int uId, String content, int forwardBlogId) throws SQLException {
        try {
            Blog forwardBlog = blogDao.findBlogById(forwardBlogId);
            int fromBid = 0;
            content = (content != null && !content.equals("")) ? content : "转发微博";
            if (forwardBlog.getState() == 2) {
                //属于转发的微博
                fromBid = forwardBlog.getOrigin().getId();
            } else {
                //属于原创微博
                fromBid = forwardBlog.getId();
            }
            return blogDao.forwardBlog(uId, content, DateUtil.now(), fromBid);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            MyBatisUtil.closeSqlSession(sqlSession);
        }
    }
}
