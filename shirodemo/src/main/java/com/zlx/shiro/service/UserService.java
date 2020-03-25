package com.zlx.shiro.service;

import com.zlx.shiro.bean.User;

import java.util.List;

public interface UserService {
    List<User> queryAll();

    User queryUserByName(String name);
}
