package com.yq.entity;

import java.io.Serializable;

/**
 * 关注关系
 */
public class Follow implements Serializable {
    private static final long serialVersionUID = 1306855464293636311L;
    private int id;
    private int uId; //用户的Id
    private int followerId; //用户关注人的id

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public int getFollowerId() {
        return followerId;
    }

    public void setFollowerId(int followerId) {
        this.followerId = followerId;
    }

}
