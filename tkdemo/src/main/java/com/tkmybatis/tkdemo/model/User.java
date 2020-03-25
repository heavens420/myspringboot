package com.tkmybatis.tkdemo.model;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2020-03-04
 */

@Data //此注解用于代替get() set()方法
@Table
public class User implements Serializable {
    private static final long serialVersionUID = 518515160285583803L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "JDBC") // 新增数据后，可以直接返回主键，数据库支持主键自增
    private Integer id;

    @Column
    private Integer age;

    @Column
    private String name;

    @Column
    private String phone;

    @Column
    private String addr;



    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", addr='" + addr + '\'' +
                '}';
    }
}