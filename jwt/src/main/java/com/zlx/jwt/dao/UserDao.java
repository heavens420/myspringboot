package com.zlx.jwt.dao;

import com.zlx.jwt.bean.User;
import org.apache.ibatis.annotations.Select;

public interface UserDao {

    @Select("select * from USER where name = #{name}")
    User findUser(String name);
}
