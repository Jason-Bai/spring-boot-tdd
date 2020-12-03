package com.javatech.tdd.configs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis配置
 * @author baiyu
 * @Desc
 * @date 2020/11/30
 */
@Configuration
@MapperScan({"com.javatech.tdd.mbg.mapper", "com.javatech.tdd.dao"})
public class MyBatisConfig {
}
