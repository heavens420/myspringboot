package com.zlx.jpa.dao;

import com.zlx.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

//泛型类型为 对应的实体类对象及其主键

//JpaRepository 具备基本的crud方法
//JpaSpecificationExecutor 具备复杂的查询操作 如分页查询

public interface UserDao extends JpaRepository<User,Integer> , JpaSpecificationExecutor<User> {

    //自定义i查询

//    @Query(value="from user where id = ?1 and name = ?2")
//    public User queryByNameId(int id,String name);

}
