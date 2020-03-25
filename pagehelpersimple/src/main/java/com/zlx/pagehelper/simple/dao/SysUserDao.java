package com.zlx.pagehelper.simple.dao;

import com.zlx.pagehelper.simple.model.SysUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysUserDao {

    //分页
    List<SysUser> selectPage();

    //查询所有 本质上这两个方法一样，.xml的sql都是查询所有写法
    List<SysUser> queryAll();
}
