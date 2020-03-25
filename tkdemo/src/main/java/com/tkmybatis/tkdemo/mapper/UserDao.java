package com.tkmybatis.tkdemo.mapper;

import base.MyBaseMapper;
import com.tkmybatis.tkdemo.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao extends MyBaseMapper<User> {
}
