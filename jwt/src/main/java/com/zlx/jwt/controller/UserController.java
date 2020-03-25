package com.zlx.jwt.controller;

import com.zlx.jwt.bean.User;
import com.zlx.jwt.service.UserService;
import com.zlx.jwt.utils.Result;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {
    @Resource
    private UserService userService;

    public Result login(String name,String passwd) throws Exception {
        User user = userService.findUser(name);
        Result result = new Result();
        if (user == null || user.getPasswd().equals(passwd)){
//            throw new Exception("账号或密码错误");
            result.setCODE("600");
            result.setSUCCESS(false);
            return result;
        }else {
            return result;
        }

    }

}
