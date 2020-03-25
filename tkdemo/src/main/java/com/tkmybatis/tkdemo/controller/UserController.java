package com.tkmybatis.tkdemo.controller;

import com.tkmybatis.tkdemo.model.User;
import com.tkmybatis.tkdemo.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("getAllUser")
    public List<User> getAllUser(){
        List<User> list = userService.selectAll();
        list.stream().forEach(user -> System.out.println(user));
        return list;
    }
}
