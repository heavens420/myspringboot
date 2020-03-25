package com.zlx.jwt.service.impl;

import com.zlx.jwt.bean.User;
import com.zlx.jwt.dao.UserDao;
import com.zlx.jwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User findUser(String name) {
        return userDao.findUser(name);
    }
}
