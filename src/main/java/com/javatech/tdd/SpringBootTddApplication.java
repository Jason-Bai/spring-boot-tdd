package com.javatech.tdd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 启动类
 * @author baiyu
 */
@SpringBootApplication
public class SpringBootTddApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootTddApplication.class, args);
    }

}
