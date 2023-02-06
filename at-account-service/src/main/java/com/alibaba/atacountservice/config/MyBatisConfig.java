package com.alibaba.atacountservice.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author clay
 * @version 1.0
 */
@Configuration
@MapperScan("com.alibaba.atacountservice.mapper")
public class MyBatisConfig {
}
