package com.alibaba.cloudprovider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigController {

    @Value("${config.address}")
    private String address;

    @GetMapping("/print/address")
    public String printAddress(){
        return address;
    }
}
