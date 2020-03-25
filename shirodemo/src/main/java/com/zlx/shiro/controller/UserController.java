package com.zlx.shiro.controller;

import com.zlx.shiro.bean.Permission;
import com.zlx.shiro.bean.User;
import com.zlx.shiro.service.PermissionService;
import com.zlx.shiro.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {

    @Resource
    private UserService userService;




    @GetMapping(value = "/userlist",produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public List<User> queryAll(){
        return userService.queryAll();
    }



}
