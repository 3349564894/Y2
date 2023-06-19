package com.yq.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 博客
 */
public class Blog implements Serializable {
    private static final long serialVersionUID = 6077696398179290981L;
    private int id;
    private int uId; //用户id
    private String content; //博客内容
    private String images; //图片
    private Date time; //发布时间
    private int state; //博客状态（1：原创 2：转发）
    private int from;//转发的原始博客id

    private User user = new User(); //发布微博的用户
    private Blog origin; //转发的原始微博

    private int commentCount;
    private int likesCount;
    private int forwardCount;
    private int collectionCount;
    private boolean isCollected;
    private boolean isLiked;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public Blog getOrigin() {
        return origin;
    }

    public void setOrigin(Blog origin) {
        this.origin = origin;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public int getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(int likesCount) {
        this.likesCount = likesCount;
    }

    public int getForwardCount() {
        return forwardCount;
    }

    public void setForwardCount(int forwardCount) {
        this.forwardCount = forwardCount;
    }

    public int getCollectionCount() {
        return collectionCount;
    }

    public void setCollectionCount(int collectionCount) {
        this.collectionCount = collectionCount;
    }

    public boolean isCollected() {
        return isCollected;
    }

    public void setCollected(boolean collected) {
        isCollected = collected;
    }

    public boolean isLiked() {
        return isLiked;
    }

    public void setLiked(boolean liked) {
        isLiked = liked;
    }
}
