package com.zlx.shiro.service.ServiceImpl;

import com.zlx.shiro.bean.Permission;
import com.zlx.shiro.bean.Role;
import com.zlx.shiro.dao.PermissionDao;
import com.zlx.shiro.service.PermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Resource
    private PermissionDao permissionDao;

    @Override
    public List<Permission> queryPermissionList(int id) {
        return permissionDao.queryPermissionList(id);
    }

}
