package com.alibaba.atacountservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.alibaba.atacountservice.mapper")
public class AtAcountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtAcountServiceApplication.class, args);
	}

}
