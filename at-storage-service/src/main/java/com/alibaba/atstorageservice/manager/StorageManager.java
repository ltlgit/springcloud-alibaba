package com.alibaba.atstorageservice.manager;

import com.alibaba.atstorageservice.bo.StorageBo;
import com.alibaba.atstorageservice.mapper.StorageMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StorageManager {
    @Resource
    private StorageMapper storageMapper;

    public boolean deductInventory(Long goodId, Integer num) {
        StorageBo storageBo = new StorageBo();
        storageBo.setNum(num);
        storageBo.setGoodId(goodId);
        Integer result = storageMapper.deductInventory(storageBo);
        return result > 0 ? true : false;
    }
}
