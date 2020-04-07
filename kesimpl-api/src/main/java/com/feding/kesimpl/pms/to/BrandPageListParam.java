package com.feding.kesimpl.pms.to;

import java.io.Serializable;

public class BrandPageListParam implements Serializable {
    private Long pageNum=1L;
    private Long pageSize=10L;
    private String keyword;//查询条件

    public Long getPageNum() {
        return pageNum;
    }

    public void setPageNum(Long pageNum) {
        this.pageNum = pageNum;
    }

    public Long getPageSize() {
        return pageSize;
    }

    public void setPageSize(Long pageSize) {
        this.pageSize = pageSize;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
