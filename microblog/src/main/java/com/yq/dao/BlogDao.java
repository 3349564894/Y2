package com.yq.dao;

import com.yq.entity.Blog;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;
import java.util.List;

public interface BlogDao {
    //统计我的微博数
    public int getBlogCount(int uId) throws SQLException;

    //跟据博客Id获取博客的转发数目
    public int getForwardCountByBid(int bid) throws SQLException;

    //根据博客Id获取博客明细
    public Blog findBlogById(int id) throws SQLException;

    //删除一条微博
    public int deleteBlog(int id) throws SQLException;

    //统计我和我的关注人的微博总数
    public int getAllBlogsCount(@Param("uId") int uId, @Param("keyword") String keyword) throws SQLException;

    //分页获取我和我的关注人的微博
    public List<Blog> getAllBlogsByPage(@Param("uId") int uId, @Param("keyword") String keyword, @Param("pageNo") int pageNo, @Param("pageSize") int pageSize) throws SQLException;

    //发布微博
    public int addNewBlog(Blog blog, @Param("now") String now) throws SQLException;

    //统计微博总数
    public int getPopBlogsCount(int uId, String keyword) throws SQLException;

    //分页查询热门微博列表
    public List<Blog> getPopBlogsByPage(@Param("uId") int uId, @Param("keyword") String keyword, @Param("pageNo") int pageNo, @Param("pageSize") int pageSize) throws SQLException;

    //根据查询关键字统计用户微博数
    public int getBlogCountByUidAndKeyword(@Param("uId") int uId, @Param("keyword") String keyword) throws SQLException;

    //分页获取我的微博列表
    public List<Blog> getMyBlogsByPage(@Param("uId") int uId, @Param("keyword") String keyword, @Param("pageNo") int pageNo, @Param("pageSize") int pageSize) throws SQLException;

    //转发微博
    public int forwardBlog(@Param("uId") int uId, @Param("content") String content, @Param("now") String now, @Param("fromBid") int fromBid) throws SQLException;
}
