package com.zlx.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

/**
 * Jpa 默认把大写字母转小写 所以数据库表名大写会报错
 */
@Entity
@Table(name = "USER")
@Data
//此注解必须加 否则报错：com.fasterxml.jackson.databind.exc.InvalidDefinitionException: No serializer
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //配置主键生成策略 自增长
    @Column(name = "id")
    private int id;

    @Column(name = "age")
    private int age;

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String phone;

    @Column(name = "addr")
    private String addr;

    @Column(name = "password")
    private String password;

    public User(int age, String name, String phone, String addr, String password) {
        this.age = age;
        this.name = name;
        this.phone = phone;
        this.addr = addr;
        this.password = password;
    }

    public User() {
    }
}
