package com.zlx.pagehelper.simple.service.serviceimpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zlx.pagehelper.simple.dao.SysUserDao;
import com.zlx.pagehelper.simple.model.SysUser;
import com.zlx.pagehelper.simple.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Resource
    private SysUserDao sysUserDao;

    //查询所有
    @Override
    public List<SysUser> queryAll() {
        return sysUserDao.queryAll();
    }

    //分页查询
    @Override
    public PageInfo<SysUser> getPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<SysUser> list = sysUserDao.selectPage();
        return new PageInfo<SysUser>(list);
    }
}
