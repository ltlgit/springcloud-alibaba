package com.alibaba.atacountservice.manager;

import com.alibaba.atacountservice.bo.AccountBo;
import com.alibaba.atacountservice.mapper.AccountMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;

@Service
public class AccountManager {
    @Resource
    private AccountMapper accountMapper;

    public boolean deductAccountBalance(Long userId, BigDecimal amount,Long accountId){
        AccountBo accountBo=new AccountBo();
        accountBo.setAccountId(accountId);
        accountBo.setAmount(amount.longValue());
        //accountBo.setGmtModified(new Date());
        accountBo.setUserId(userId);
        Integer result=accountMapper.deductAccountBalance(accountBo);
        return result>0?true:false;
    }
}
