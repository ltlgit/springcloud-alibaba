package com.alibaba.cloudconsumer.config;

import com.alibaba.cloud.nacos.NacosDiscoveryProperties;
import com.alibaba.cloud.nacos.NacosServiceManager;
import com.alibaba.cloud.nacos.ribbon.ExtendBalancer;
import com.alibaba.cloud.nacos.ribbon.NacosServer;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.DynamicServerListLoadBalancer;
import com.netflix.loadbalancer.Server;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
public class NacosRule extends AbstractLoadBalancerRule {

    @Autowired
    private NacosDiscoveryProperties nacosDiscoveryProperties;
    @Autowired
    private NacosServiceManager nacosServiceManager;

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    @Override
    public Server choose(Object o) {
        try {
            //获取集群名称
            String clusterName = nacosDiscoveryProperties.getClusterName();
            //获取组名称
            String group = nacosDiscoveryProperties.getGroup();
            DynamicServerListLoadBalancer loadBalancer = (DynamicServerListLoadBalancer)getLoadBalancer();
            //获取服务名称
            String name = loadBalancer.getName();
            //获取nacos名字服务对象
            NamingService namingService = nacosServiceManager.getNamingService(nacosDiscoveryProperties.getNacosProperties());
            //从nacos注册中心获取健康的服务实例列表
            List<Instance> instances = namingService.selectInstances(name, group, true);
            if(CollectionUtils.isEmpty(instances)){
                log.warn("no instance in service {}",name);
                return null;
            }
            //剔除不属于本集群的服务实例，不允许跨集群负载均衡
            List<Instance> instancesToChoose = instances;
            if(StringUtils.isNotBlank(clusterName)){
                List<Instance> sameClusterInstances = instances.stream().filter(instance -> Objects.equals(clusterName, instance.getClusterName()))
                        .collect(Collectors.toList());
                if(!CollectionUtils.isEmpty(sameClusterInstances)){
                    instancesToChoose = sameClusterInstances;
                }else {
                    log.warn("A cross-cluster call occurs,name={},clusterName={},instances={}",name,clusterName,instances);
                }
            }
            //按照服务实例权重，从服务列表中选出提供服务的实例
            Instance instance = ExtendBalancer.getHostByRandomWeight2(instancesToChoose);
            //返回选中实例
            return new NacosServer(instance);
        } catch (NacosException e) {
            log.warn("NacosRule error:",e);
            return null;
        }

    }
}
