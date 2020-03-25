package com.zlx.redistemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RedistemplateApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedistemplateApplication.class, args);
    }

}
