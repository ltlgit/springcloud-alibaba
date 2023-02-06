package com.alibaba.atstorageservice.mapper;

import com.alibaba.atstorageservice.entity.OrderEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper{
    Long createOrder(OrderEntity orderEntity);
    Integer updataOrderStatus(OrderEntity orderEntity);
}
