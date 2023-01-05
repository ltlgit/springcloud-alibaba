package com.alibaba.cloudprovider.controller;

import com.alibaba.cloudprovider.service.RibbonDiscoveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/provider")
public class ProviderController {

    @Autowired
    private RibbonDiscoveryService ribbonDiscoveryService;

    @GetMapping(value = "/getRibbonConfig")
    @ResponseBody
    public String testRestRibbon(){
        //返回当前实例的节点信息，IP地址，端口号
        return ribbonDiscoveryService.getRibbonConfig();
    }
}
