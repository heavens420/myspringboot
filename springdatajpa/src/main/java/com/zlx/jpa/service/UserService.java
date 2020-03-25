package com.zlx.jpa.service;

import com.zlx.jpa.dao.UserDao;
import com.zlx.jpa.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.ReactiveTransaction;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {
    @Resource
    private UserDao userDao;

    //查询一个 懒加载 findOne（）立即加载
    public User getOne(int id){
        return userDao.getOne(id);
    }


    public List<User> queryAll(){
        return userDao.findAll();
    }

    public User save(User user){
        return userDao.save(user);
    }

    public void delete(User user){
         userDao.delete(user);
    }

//    public User queryByNameId(int id,String name){
//        return userDao.queryByNameId(id,name);
//    }
}
