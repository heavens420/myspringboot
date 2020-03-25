package com.zlx.shiro.service;

import com.zlx.shiro.bean.Permission;
import com.zlx.shiro.bean.Role;

import java.util.List;

public interface PermissionService {
    List<Permission> queryPermissionList(int id);
}
