package com.alibaba.atacountservice.service;

import java.math.BigDecimal;

public interface AtAccountService {

    boolean deductAccountBalance(Long userId, BigDecimal amount, Long accountId);
}
