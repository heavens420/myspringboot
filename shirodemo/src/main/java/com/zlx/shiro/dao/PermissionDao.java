package com.zlx.shiro.dao;

import com.zlx.shiro.bean.Permission;
import com.zlx.shiro.bean.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PermissionDao {
    List<Permission> queryPermissionList(int id);
}
