package com.zlx.jpa.controller;

import com.zlx.jpa.dao.UserDao;
import com.zlx.jpa.entity.User;
import com.zlx.jpa.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Api(value = "user的控制层")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("getone")
    @ApiOperation(value = "根据id查询用户",notes = "参数为int")
    public User findOne(@RequestParam(defaultValue = "1") @RequestBody int id){
        if (!StringUtils.isEmpty(id)){
            return userService.getOne(id);
        }
        System.out.println("canshu wei null");
        return new User();
    }

    @GetMapping("queryAll")
    public List<User> queryAll(){
        return userService.queryAll();
    }

    //新增用户 数据库无该id 新增
    @PostMapping("/add")
    public User add(){
        User user = new User(23,"ll","333","bj","888");
//        user.setId(18);
        return userService.save(user);
    }

    //修改用户  数据库中有该用户 更新字段  为修改的默认为null 故不推荐使用
    @GetMapping("update")
    public User update(){
        User user = new User();
        user.setId(2);
        user.setName("hh");
        return userService.save(user);
    }

//    @GetMapping("12")
//    public User queryBynameId(int id,String name){
//        return userService.queryByNameId(2,"hh");
//    }
}
