package com.zlx.crud.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 配置跨域请求
 * 不需要在接口上加 @OrigigonCross注解
 */

@Configuration
public class OrigionCross implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://jing.tk") //或配置 *
                .allowedHeaders("*")
                .allowedMethods("*")
                .maxAge(30*1000); //put请求在发请求前会发送探测请求 设置探测请求过期时间
    }
}
