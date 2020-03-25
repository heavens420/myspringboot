package com.zlx.redistemplate.controller;

import com.zlx.redistemplate.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("1")
    public String pig(){
        stringRedisTemplate.opsForValue().set("pig","bigpig");
        return stringRedisTemplate.opsForValue().get("pig");
    }

    @RequestMapping("2")
    public User getUser(){
        User user = new User("gg","888");
        redisTemplate.opsForValue().set("user",user);
        return (User) redisTemplate.opsForValue().get("user");
    }

    @RequestMapping("3")
    //秒分时日月周（年） 必须写六个属性
    @Scheduled(cron = "*/2 * * * * ?")
    public List getList(){
        stringRedisTemplate.opsForList().leftPush("lt","3k");
        stringRedisTemplate.opsForList().leftPush("lt","2k");
        stringRedisTemplate.opsForList().leftPush("lt","1k");

        stringRedisTemplate.opsForList().leftPop("lt");
        stringRedisTemplate.opsForList().rightPop("lt");

        return  stringRedisTemplate.opsForList().range("it",0,9);
    }
}
