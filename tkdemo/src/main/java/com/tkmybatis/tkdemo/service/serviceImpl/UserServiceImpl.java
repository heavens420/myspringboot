package com.tkmybatis.tkdemo.service.serviceImpl;

import com.tkmybatis.tkdemo.model.User;
import com.tkmybatis.tkdemo.service.UserService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public int deleteByPrimaryKey(Object o) {
        return 0;
    }

    @Override
    public int delete(User user) {
        return 0;
    }

    @Override
    public int insert(User user) {
        return 0;
    }

    @Override
    public int insertSelective(User user) {
        return 0;
    }

    @Override
    public boolean existsWithPrimaryKey(Object o) {
        return false;
    }

    @Override
    public List<User> selectAll() {
        return null;
    }

    @Override
    public User selectByPrimaryKey(Object o) {
        return null;
    }

    @Override
    public int selectCount(User user) {
        return 0;
    }

    @Override
    public List<User> select(User user) {
        return null;
    }

    @Override
    public User selectOne(User user) {
        return null;
    }

    @Override
    public int updateByPrimaryKey(User user) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(User user) {
        return 0;
    }
}
