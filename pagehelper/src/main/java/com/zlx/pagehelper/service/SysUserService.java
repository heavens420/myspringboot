package com.zlx.pagehelper.service;

import com.zlx.pagehelper.model.SysUser;
import com.zlx.pagehelper.util.PageRequest;
import com.zlx.pagehelper.util.PageResult;

import java.util.List;

public interface SysUserService {

    List<SysUser> selectAll();

    PageResult selectPage(PageRequest pageRequest);
}
