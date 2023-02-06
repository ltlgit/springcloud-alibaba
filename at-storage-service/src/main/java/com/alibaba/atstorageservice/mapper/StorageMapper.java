package com.alibaba.atstorageservice.mapper;

import com.alibaba.atstorageservice.bo.StorageBo;

public interface StorageMapper {
    Integer deductInventory(StorageBo storageBo);
}
