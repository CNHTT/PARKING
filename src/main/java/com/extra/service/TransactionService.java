package com.extra.service;

import com.extra.model.RechargeBean;
import com.extra.model.response.ResponsePage;

public interface TransactionService {
    ResponsePage<RechargeBean> loadRechargeList(String companyUUID, Integer pageName);
}
