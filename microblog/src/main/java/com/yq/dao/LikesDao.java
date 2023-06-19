package com.yq.dao;

import com.yq.entity.Blog;
import com.yq.entity.Likes;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;
import java.util.List;

public interface LikesDao {
    //根据微博id获取微博的点赞数目
    public int getLikeCountByBid(int bid) throws SQLException;

    //删除某条微博的所有点赞
    public int deleteLikesByBid(int bid) throws SQLException;

    //分页获取我的赞列表
    public List<Blog> getLikeBlogsByPage(@Param("uid") int uid, @Param("keyword") String keyword, @Param("pageNo") int pageNo, @Param("pageSize") int pageSize) throws SQLException;

    //获取我的赞总数
    public int getLikesCountByUidAndKeyword(@Param("uid") int uid, @Param("keyword") String keyword) throws SQLException;

    //点赞一条微博
    public int addLikes(Likes likes, @Param("now") String now) throws SQLException;

    //查询是否已点赞该微博
    public Likes findLikes(@Param("uid") int uid, @Param("bid") int bid) throws SQLException;

    //取消点赞
    public int deleteLikes(Likes likes) throws SQLException;
}
