package com.zlx.pagehelper.simple.service;

import com.github.pagehelper.PageInfo;
import com.zlx.pagehelper.simple.model.SysUser;

import java.util.List;

public interface SysUserService {

    List<SysUser> queryAll();

    PageInfo<SysUser> getPage(int pageNum,int pageSize);

}
