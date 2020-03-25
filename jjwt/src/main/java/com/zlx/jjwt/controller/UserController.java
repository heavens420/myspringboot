package com.zlx.jjwt.controller;

import com.zlx.jjwt.bean.User;
import com.zlx.jjwt.service.UserService;
import com.zlx.jjwt.utils.JwtUtils;
import com.zlx.jjwt.utils.Result;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

import static com.zlx.jjwt.utils.JwtUtils.paraseToken;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("login")
    public Result login(String name, String passwd, HttpServletResponse response) {
//        String name = loginMap.get("name");
//        String passwd = loginMap.get("passwd");

//        new JwtUtils().setKey("nihaoa");
//        System.out.println(name+"   "+passwd);
        User user = service.findUser(name);
        if (user == null || !user.getPasswd().equals(passwd)) {
            Result result = new Result();
            result.setCode(1000);
            result.setMessage("用户名或密码错误");
            result.setSuccess(false);
            return result;
        } else {
            Result result = new Result();
            Map map = new HashMap();
            map.put("name", user.getName());
            map.put("age", user.getAge());
            map.put("addr", user.getAddr());

            String token = jwtUtils.createToken(user.getId() + "", user.getName(), map);

            response.setHeader("Authorization", token);

            result.setSuccess(true);
            result.setCode(2000);
            result.setMessage("登录成功");
            result.setObject(map);
            result.setObject(token);
            return result;
        }
    }

    @PostMapping("profile")
    public Map<String, Object> getProfile(HttpServletRequest request/*,String authorization*/) throws Exception {

        //获取请求头
        String authorization = request.getHeader("Authorization");
//        authorization = new String(authorization.getBytes(),"utf-8");
//        System.out.println(authorization);
        //判空 请求头
        if (StringUtils.isEmpty(authorization)) {
            throw new Exception("请登录后操作");
        }

        //将token中的 bearer 替换为空
        String token = authorization.replace("bearer", " ");

        //解析token
        Claims claims = JwtUtils.paraseToken(token);

        Map map = new HashMap();
        map.put("解析后的token", claims);
        map.put("message", "已验证token");

        return map;
    }
}
