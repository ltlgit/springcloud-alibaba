package com.alibaba.atacountservice.mapper;

import com.alibaba.atacountservice.bo.AccountBo;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface AccountMapper{
    Integer deductAccountBalance(AccountBo accountBo);
}
