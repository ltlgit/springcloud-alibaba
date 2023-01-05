package com.alibaba.cloudprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class CloudProvider1Application {

	public static void main(String[] args) {
		SpringApplication.run(CloudProvider1Application.class, args);
	}

}
