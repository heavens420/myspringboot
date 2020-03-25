package com.zlx.jjwt.bean;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class User {
    private Integer id;

    private Integer age;

    private String name;

    private String phone;

    private String addr;

    private Timestamp time;

    private String passwd;
}
