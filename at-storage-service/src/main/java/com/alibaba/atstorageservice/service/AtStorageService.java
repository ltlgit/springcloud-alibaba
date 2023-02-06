package com.alibaba.atstorageservice.service;

public interface AtStorageService {

    boolean deductInventory(Long goodId,Integer num);
}
