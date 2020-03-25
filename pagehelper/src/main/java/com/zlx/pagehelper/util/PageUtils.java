package com.zlx.pagehelper.util;

import com.github.pagehelper.PageInfo;

public class PageUtils {
    /**
     * 将分页结果封装到统一的接口
     */
    public static PageResult getPageResult(PageRequest pageRequest, PageInfo<?> pageInfo){
        PageResult pageResult = new PageResult();
        pageResult.setPageNum(pageInfo.getPageNum());
        pageResult.setPageSize(pageInfo.getPageSize());
        pageResult.setTotalSize(pageInfo.getTotal());
        pageResult.setTotalPages(pageInfo.getPages());
        pageResult.setContent(pageInfo.getList());
        pageResult.setStatus(true);
        pageResult.setMsg("success");
        return pageResult;
    }
}
