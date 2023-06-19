package com.yq.crm.util;

import org.springframework.context.annotation.Scope;

import java.util.List;

//@Scope("singleton")
public class Page<T> {
    //总页数
    private int pages;
    //页面大小，即每页显示记录数
    private int pageSize = 2;
    //记录总数
    private int total;
    //当前页码
    private int current = 1;


    //mysql==>limit 偏移量,显示的数量
    private Integer offset;

    //集合
    private List<T> list;


    public Page() {
    }

    public Page(int pages, int pageSize, int total, int current, Integer offset, List<T> list) {
        this.pages = pages;
        this.pageSize = pageSize;
        this.total = total;
        this.current = current;
        this.offset = offset;
        this.list = list;
    }

    /**
     * 获取
     *
     * @return pages
     */
    public int getPages() {
        pages = total % pageSize == 0 ? total / pageSize : total / pageSize + 1;
        return pages;
    }

    /**
     * 设置
     *
     * @param pages
     */
    public void setPages(int pages) {
        this.pages = pages;
    }

    /**
     * 获取
     *
     * @return pageSize
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * 设置
     *
     * @param pageSize
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * 获取
     *
     * @return total
     */
    public int getTotal() {
        return total;
    }

    /**
     * 设置
     *
     * @param total
     */
    public void setTotal(int total) {
        this.total = total;
    }

    /**
     * 获取
     *
     * @return current
     */
    public int getCurrent() {
        return current;
    }

    /**
     * 设置
     *
     * @param current
     */
    public void setCurrent(int current) {
        this.current = current;
    }

    /**
     * 获取
     *
     * @return offset
     */
    public Integer getOffset() {
        offset = (current - 1) * pageSize;
        return offset;
    }

    /**
     * 设置
     *
     * @param offset
     */
    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    /**
     * 获取
     *
     * @return list
     */
    public List<T> getList() {
        return list;
    }

    /**
     * 设置
     *
     * @param list
     */
    public void setList(List<T> list) {
        this.list = list;
    }

    public String toString() {
        return "Page{pages = " + pages + ", pageSize = " + pageSize + ", total = " + total + ", current = " + current + ", offset = " + offset + ", list = " + list + "}";
    }
}
