package com.zlx.jpa.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyException {

    @ExceptionHandler(value = Exception.class) //捕捉总异常
    public Map<String,Object> exceptionAdvise(Exception e){
        Map map = new HashMap();
        map.put("code","x90gj8");
        map.put("msg","异常:"+e.getMessage());

        return map;
    }
}
