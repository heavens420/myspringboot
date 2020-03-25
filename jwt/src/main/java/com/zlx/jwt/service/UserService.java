package com.zlx.jwt.service;

import com.zlx.jwt.bean.User;

public interface UserService {
    User findUser(String name);
}
