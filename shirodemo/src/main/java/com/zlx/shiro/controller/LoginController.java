package com.zlx.shiro.controller;

import com.zlx.shiro.bean.User;
import com.zlx.shiro.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
public class LoginController {

    @Resource
    private UserService userService;

    @RequestMapping("/")
    public String login(){
        return "/login";
    }

    @RequestMapping("login")
    public String toLogin(User user, String rememberMe, ModelMap modelMap){
        Subject currentUser = SecurityUtils.getSubject();
//        if (currentUser.isRemembered()){
//            modelMap.addAttribute("msg","ciyonghu shi jizhu yonghu");
//        }
        UsernamePasswordToken token = new UsernamePasswordToken(user.getName(),user.getPassword());

        User currentUser1 = userService.queryUserByName(token.getUsername());
        System.out.println("currentUser:"+currentUser);
        System.out.println("currentUser1:"+currentUser1);
//        if (rememberMe != null){
//            token.setRememberMe(true);
//            modelMap.addAttribute("msg","shezhi jizhu yonghu ");
//        }

        //开始登录
        try {
            //无异常即成功登录
            currentUser.login(token);
        }catch (UnknownAccountException e){
            modelMap.put("msg","用户不存");
            return "/h2";
        }catch (IncorrectCredentialsException e){
            modelMap.put("msg","密码错误");
            return "/h3";
        }
        return "redirect:/success";
    }
}
