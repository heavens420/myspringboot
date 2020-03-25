package com.zlx.jjwt.dao;

import com.zlx.jjwt.bean.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    User findUser(String name);
}
