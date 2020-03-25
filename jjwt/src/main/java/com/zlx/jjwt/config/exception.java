package com.zlx.jjwt.config;

import com.fasterxml.jackson.core.JsonParseException;
import io.jsonwebtoken.ExpiredJwtException;
import org.apache.ibatis.exceptions.TooManyResultsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class exception {
    @ExceptionHandler(value = TooManyResultsException.class)
    @ResponseBody
    public Map<String, Object> tooMany(Exception e) {
        Map map = new HashMap();
        map.put("msg", "we find one more from your input please reinput again");
        map.put("exception", e.getMessage());
        return map;
    }

    @ExceptionHandler(value = NullPointerException.class)
    @ResponseBody
    public Map<String, Object> nullPointer(Exception e) {
        Map map = new HashMap();
        map.put("msg", "your params is less than required,please reinput again if you have input please recheck that whether it is right");
        map.put("exception", e.getMessage());
        return map;
    }

    @ExceptionHandler(value = JsonParseException.class)
    @ResponseBody
    public Map<String, Object> JsonParseException(Exception e) {
        Map map = new HashMap();
        map.put("msg", "token无效或超时(可能性不大)或已被篡改(可能性很大)");
        map.put("exception", e.getMessage());
        return map;
    }

    @ExceptionHandler(value = ExpiredJwtException.class)
    @ResponseBody
    public Map<String, Object> ExpiredJwtException(Exception e) {
        Map map = new HashMap();
        map.put("msg", "token 已过期");
        map.put("exception", e.getMessage());
        return map;
    }
}
