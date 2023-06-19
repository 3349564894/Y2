package com.yq.service;

import com.yq.entity.Likes;
import com.yq.util.Page;

import java.sql.SQLException;

public interface LikesService {
    //根据微博id获取微博的点赞数目
    public int getLikeCountByBid(int bid) throws SQLException;

    //删除某条微博的所有点赞
    public int deleteLikesByBid(int bid) throws SQLException;

    //分页获取我的赞微博列表
    public void getLikeBlogsByPage(int uid, String keyword, Page pageObj) throws SQLException;

    //点赞一条微博
    public int addLikes(Likes likes) throws SQLException;

    //查询是否已点赞该微博
    public Likes findLikes(int uid, int bid) throws SQLException;

    //取消点赞
    public int deleteLikes(Likes likes) throws SQLException;
}
