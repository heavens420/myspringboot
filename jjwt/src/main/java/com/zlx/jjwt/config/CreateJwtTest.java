package com.zlx.jjwt.config;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * 创建token
 */
public class CreateJwtTest {
    public static void main(String[] args) {
        JwtBuilder builder = Jwts.builder().setId("001")
                .setSubject("nihao")
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "mysecret")
                .claim("name", "xiaoxi")
                .claim("age", "100");

        String token = builder.compact();
        System.out.println(token);
    }
}
