package com.alibaba.atacountservice.service.impl;

import com.alibaba.atacountservice.manager.AccountManager;
import com.alibaba.atacountservice.service.AtAccountService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import java.math.BigDecimal;

@DubboService(version = "1.0.0",group = "SEATA_GROUP")
public class AtAccountServiceImpl implements AtAccountService {

    @Autowired
    private AccountManager accountManager;

    @Override
    public boolean deductAccountBalance(Long userId, BigDecimal amount,Long accountId) {
        return accountManager.deductAccountBalance(userId,amount,accountId);
    }
}
