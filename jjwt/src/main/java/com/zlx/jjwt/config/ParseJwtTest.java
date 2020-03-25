package com.zlx.jjwt.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

/**
 * 解析 token
 */
public class ParseJwtTest {
    public static void main(String[] args) {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIwMDEiLCJzdWIiOiJuaWhhbyIsImlhdCI6MTU4NDk1NTU4MSwibmFtZSI6InhpYW94aSIsImFnZSI6IjEwMCJ9." +
                "_XgdpgOeEQ8qzYstuL_XncFaALS-zbwr082Fsue8J34";
        //获取token体
        Claims claims = Jwts.parser().setSigningKey("mysecret").parseClaimsJws(token).getBody();

        //私有数据存放在claims
        System.out.println(claims.getId());
        System.out.println(claims.getSubject());
        System.out.println(claims.getIssuedAt());

        //获取自定义的claim内容
        String name = (String) claims.get("name");
        String age = (String) claims.get("age");

        System.out.println(name + "    " + age);
    }
}
