package com.alibaba.atstorageservice.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author clay
 * @version 1.0
 */
@Configuration
@MapperScan("com.alibaba.attradeservice.mapper")
public class MyBatisConfig {
}
