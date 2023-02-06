package com.alibaba.atacountservice.bo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class AccountBo {
    private Long id;
    private String accountName;
    private Long accountId;
    private Long userId;
    private Long amount;
    private Date gmtModified;
    private Integer isDeleted;
}
