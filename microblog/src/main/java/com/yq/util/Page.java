package com.yq.util;

import com.yq.entity.Blog;
import com.yq.entity.Comment;

import java.util.List;

public class Page {
    //总页数
    private int totalPageCount = 0;
    //页面大小，即每页显示记录数
    private int pageSize = 10;
    //记录总数
    private int totalCount;
    //当前页码
    private int currPageNo = 0;
    //每页微博集合
    private List<Blog> blogsList;
    //每页评论结合
    private List<Comment> commentList;
    private int offset;

    public int getOffset() {
        offset = currPageNo * pageSize;
        return offset;
    }

    public int getCurrPageNo() {
        if (totalPageCount == 0) {
            return 0;
        }
        return currPageNo;
    }

    public void setCurrPageNo(int currPageNo) {
        if (currPageNo > 0) {
            this.currPageNo = currPageNo;
        }
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        if (pageSize > 0) {
            this.pageSize = pageSize;
        }
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        if (totalCount > 0) {
            this.totalCount = totalCount;
            //计算总页数
            totalPageCount = this.totalCount % pageSize == 0 ?
                    (this.totalCount / pageSize) : (this.totalCount / pageSize + 1);
        }
    }

    public int getTotalPageCount() {
        return totalPageCount;
    }

    public void setTotalPageCount(int totalPageCount) {
        this.totalPageCount = totalPageCount;
    }

    public List<Blog> getBlogsList() {
        return blogsList;
    }

    public void setBlogsList(List<Blog> blogsList) {
        this.blogsList = blogsList;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }
}
