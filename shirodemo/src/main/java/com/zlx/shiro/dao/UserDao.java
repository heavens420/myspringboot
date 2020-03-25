package com.zlx.shiro.dao;

import com.zlx.shiro.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {


    List<User> queryAll();

    User queryUserByName(String name);
}
