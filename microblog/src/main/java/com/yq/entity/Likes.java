package com.yq.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 点赞
 */
public class Likes implements Serializable {
    private static final long serialVersionUID = -1752602547735397537L;
    private int id;
    private int uid;//用户id
    private int bid;//博客id
    private Date time;//点赞时间

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
