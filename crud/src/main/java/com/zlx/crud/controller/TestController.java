package com.zlx.crud.controller;

import com.zlx.crud.entity.User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class TestController {


    @GetMapping("/1")
    public Map<String,Object> GetUser(String a,int b){
        Map<String,Object> map = new HashMap();
        List list = new ArrayList();
        User user1 = new User(12, 22, "mao");
        User user2 = new User(13, 24, "xi");
        list.add(user1);
        list.add(user2);
        map.put("users",list);
        System.out.println("a= "+a);
        System.out.println("b= "+b);
        return map;
    }

    @PostMapping("2")
    public List<User> getAll(String pass,String username){
        List list = new ArrayList();
        User user1 = new User(12, 22, "mao");
        User user2 = new User(13, 24, "xi");
        list.add(user1);
        list.add(user2);
        System.out.println("pass= "+pass);
        System.out.println("username= "+username);
        list.add(user1);
        list.add(user2);
        return list;
    }
}
