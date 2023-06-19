package com.yq.service;

import com.yq.entity.Collection;
import com.yq.util.Page;

import java.sql.SQLException;

public interface CollectionService {
    //根据微博id获取微博的收藏数目
    public int getCollectionCountByBid(int bid) throws SQLException;

    //收藏一条微博
    public int addCollection(Collection collection) throws SQLException;

    //查询是否已收藏该微博
    public Collection findCollection(int uid, int bid) throws SQLException;

    //取消收藏
    public int deleteCollection(Collection collection) throws SQLException;

    //删除某条微博的收藏记录
    public int deleteCollectionByBid(int bid) throws SQLException;

    //分页获取我的收藏列表
    public void getCollectionsByPage(int uid, String keyword, Page pageObj) throws SQLException;
}
