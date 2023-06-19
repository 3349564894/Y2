package com.yq.service;

import com.yq.entity.Blog;
import com.yq.util.Page;

import java.sql.SQLException;

public interface BlogService {
    //根据id获取
    public Blog getBlogById(int id) throws SQLException;

    //跟据博客Id获取博客的转发数目
    public int getForwardCountByBid(int bid) throws SQLException;

    //删除一条微博
    public int deleteBlog(int id) throws SQLException;

    //统计我的微博数
    public int getBlogCount(int uId) throws SQLException;

    //分页获取我和我的关注人的微博列表
    public void getAllBlogsByPage(int uId, String keyword, Page pageObj) throws SQLException;

    //发布微博
    public int addNewBlog(Blog blog) throws SQLException;

    //分页获取热门微博列表
    public void getPopBlogsByPage(int uId, String keyword, Page pageObj) throws SQLException;

    //分页获取我的微博列表
    public void getMyBlogsByPage(int uId, String keyword, Page pageObj) throws SQLException;

    //转发微博
    public int forwardBlog(int uId, String content, int forwardBlogId) throws SQLException;
}
