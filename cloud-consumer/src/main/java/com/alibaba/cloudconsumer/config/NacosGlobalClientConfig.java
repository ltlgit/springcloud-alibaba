package com.alibaba.cloudconsumer.config;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;

/**
 * 配置全局负载均衡
 * */
@Configuration
@RibbonClient(name = "nacos-provider",
              configuration = NacosRibbonRuleConfig.class)
public class NacosGlobalClientConfig {
}
