package com.yq.service;

import com.yq.entity.Follow;
import com.yq.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface FollowService {
    //统计关注人数目
    public int getFollowedCount(int uId) throws SQLException;

    //统计粉丝数
    public int getFansCount(int uId) throws SQLException;

    //获取关注列表
    public List<User> getFollowedByUidAndKeyword(int uId, String keyword) throws SQLException;

    //获取粉丝列表
    public List<User> getFansByUidAndKeyword(int uId, String keyword) throws SQLException;

    //查询uId 对象是否已关注followerId对象
    public boolean isFollowed(int uId, int followedUid) throws SQLException;

    //加关注
    public int addFollower(Follow follow) throws SQLException;

    //取消关注
    public int deleteFollower(Follow follow) throws SQLException;
}
