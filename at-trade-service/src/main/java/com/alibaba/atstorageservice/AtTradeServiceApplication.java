package com.alibaba.atstorageservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.alibaba.attradeservice.mapper")
public class AtTradeServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(AtTradeServiceApplication.class, args);
    }
}
