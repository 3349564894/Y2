package com.yq.dao;

import com.yq.entity.Blog;
import com.yq.entity.Collection;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;
import java.util.List;

public interface CollectionDao {
    //根据微博id获取微博的收藏数目
    public int getCollectionCountByBid(int bid) throws SQLException;

    //收藏一条微博
    public int addCollection(Collection collection) throws SQLException;

    //查询是否已收藏该微博
    public Collection findCollection(@Param("uid") int uid, @Param("bid") int bid) throws SQLException;

    //取消收藏
    public int deleteCollection(Collection collection) throws SQLException;

    //删除某条微博的收藏记录
    public int deleteCollectionByBid(int bid) throws SQLException;

    //根据用户id和搜索关键字统计收藏的微博总数
    public int getCollectionCountByUidAndKeyword(@Param("uid") int uid, @Param("keyword") String keyword) throws SQLException;

    //分页获取收藏列表
    public List<Blog> getCollectionsByPage(@Param("uid") int uid, @Param("keyword") String keyword, @Param("pageNo") int pageNo, @Param("pageSize") int pageSize) throws SQLException;

}
