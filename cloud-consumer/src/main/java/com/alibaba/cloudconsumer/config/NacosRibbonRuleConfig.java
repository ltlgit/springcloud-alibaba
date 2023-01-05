package com.alibaba.cloudconsumer.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@Configuration
public class NacosRibbonRuleConfig {

    /**
     * 初始化NacosRule实例
     * */
    @Bean
    public NacosRule nacosRule(){
        return new NacosRule();
    }

    /**
     * 初始化RestTemplate实例
     * */
    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    };
}
