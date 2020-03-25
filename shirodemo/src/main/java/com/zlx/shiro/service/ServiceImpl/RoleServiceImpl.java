package com.zlx.shiro.service.ServiceImpl;

import com.zlx.shiro.bean.Role;
import com.zlx.shiro.dao.RoleDao;
import com.zlx.shiro.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleDao roleDao;

    @Override
    public List<Role> queryRoleListById(int id) {
        return roleDao.queryRoleListById(id);
    }

    @Override
    public Role queryRoleById(int id) {
        return roleDao.queryRoleById(id);
    }
}
