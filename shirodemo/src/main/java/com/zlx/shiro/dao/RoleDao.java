package com.zlx.shiro.dao;

import com.zlx.shiro.bean.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleDao {
    List<Role> queryRoleListById(int id);

    Role queryRoleById(int id);
}
