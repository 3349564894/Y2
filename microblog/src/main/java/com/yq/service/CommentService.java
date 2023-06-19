package com.yq.service;

import com.yq.entity.Comment;
import com.yq.util.Page;

import java.sql.SQLException;
import java.util.List;

public interface CommentService {
    // 根据微博id获取微博评价数目
    public int getCommentCountByBid(int bid) throws SQLException;

    //获取微博评论列表
    public List<Comment> getCommentsByBid(int bid) throws SQLException;

    //添加评论
    public int addComment(Comment comment) throws SQLException;

    //删除某条微博评论
    public int deleteCommentsByBid(int bid) throws SQLException;

    //分页获取评论列表
    public void getCommentsByPage(int bid, Page page) throws SQLException;
}
