package com.alibaba.cloudprovider.service.impl;

import com.alibaba.cloudprovider.service.RibbonDiscoveryService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.net.InetAddress;

@Service
@DubboService(version = "1.0.0",group = "ribbon-provider")
public class RibbonDiscoveryServiceImpl implements RibbonDiscoveryService {

    @Autowired
    private Environment environment;

    @Override
    public String getRibbonConfig() {
        String port = environment.getProperty("local.server.port");
        String ip = "";
        try {
            ip = InetAddress.getLocalHost().toString();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        String result = "负载均衡成功！" + "当前机器节点IP地址为：" + ip + ":" + port;
        return result;
    }
}
