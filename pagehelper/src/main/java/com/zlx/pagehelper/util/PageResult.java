package com.zlx.pagehelper.util;

/**
 * 分页结果
 */
public class PageResult {

    /**
     *当前页码
     *
     */
    private int pageNum;

    /**
     *每页数量
     */
    private int pageSize;

    /**
     *记录总数
     */
    private long totalSize;

    /**
     * 页码总数
     */
    private int totalPages;

    /**
     * 状态
     */
    private boolean status;

    /**
     *信息
     */
    private String msg;

    /**
     *数据模型
     */
//    private List<?> content;
    private Object content;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(long totalSize) {
        this.totalSize = totalSize;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
