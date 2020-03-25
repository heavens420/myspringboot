package com.zlx.shiro.service.ServiceImpl;

import com.zlx.shiro.bean.User;
import com.zlx.shiro.dao.UserDao;
import com.zlx.shiro.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.validation.constraints.Null;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public List<User> queryAll() {
        return userDao.queryAll();
    }

    @Override
    public User queryUserByName(String name) {
        return userDao.queryUserByName(name);
    }
}
