package com.zlx.shiro.service;

import com.zlx.shiro.bean.Role;

import java.util.List;

public interface RoleService {
    List<Role> queryRoleListById(int id);
    Role queryRoleById(int id);
}
