package com.zlx.jjwt.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

/**
 * JWT工具类
 */

@Data
@ConfigurationProperties(prefix = "jwt.config")
@Component
//@PropertySource(value = "classpath:application.yml")
public class JwtUtils {

    //设置私钥
//    @Value("$(key)")
    //设为静态 无法通过@ConfigurationProperties从 application.yml中取值
    private static String key = "nihaoa";
    //设置失效时间
//    @Value("$(jwt.config.ttl)")
    private Long ttl;

    /**
     * 设置认证token
     * id：用户登录
     * subject: 登录用户名
     */

//    @Bean
    public String createToken(String id, String name, Map<String, Object> map) {

        //创建失效时间
        long currentTime = System.currentTimeMillis();

        long exp = currentTime + ttl;

        //创建Jwtbuilder
        JwtBuilder builder = Jwts.builder().setId(id)
                .setSubject(name)
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, key);

        //根据map 设置claims
        builder.setClaims(map);

        //设置失效时间
        builder.setExpiration(new Date(exp));

        //创建token
        String token = builder.compact();

//        System.out.println(getKey()+"  "+getTtl());

        return token;
    }

    //解析token
//    @Bean
    public static Claims paraseToken(String token) {
        Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
        return claims;
    }
}
