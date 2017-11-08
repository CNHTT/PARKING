package com.extra.service;

import com.extra.model.ConsumptionBean;
import com.extra.model.RechargeBean;
import com.extra.model.response.ResponsePage;

public interface TransactionService {
    ResponsePage<RechargeBean> loadRechargeList(String companyUUID, Integer pageName);
    ResponsePage<RechargeBean> loadRechargeListByLPM(String companyUUID, Integer pageName, String lpm);
    ResponsePage<ConsumptionBean> loadConsumptionList(String companyUUID, Integer pageName);
}
