package com.alibaba.cloudconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/ribbon")
public class NacosRibbonController {


    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/test")
    public String doRibbon(){
        //通过带有负载功能的RestTemplate访问服务提供者的服务实例
        return restTemplate.getForObject("http://nacos-provider/provider/getRibbonConfig",String.class);
    }
}
