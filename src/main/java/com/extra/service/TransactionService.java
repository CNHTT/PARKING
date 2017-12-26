package com.extra.service;

import com.extra.model.ConsumptionBean;
import com.extra.model.ParkingRecordBean;
import com.extra.model.RechargeBean;
import com.extra.model.response.ResponsePage;

import java.util.ArrayList;

public interface TransactionService {
    ResponsePage<RechargeBean> loadRechargeList(String companyUUID, Integer pageName);
    ResponsePage<RechargeBean> loadRechargeListByLPM(String companyUUID, Integer pageName, String lpm);
    ResponsePage<ConsumptionBean> loadConsumptionList(String companyUUID, Integer pageName);

    boolean addRecharge(RechargeBean rechargeBean);

    boolean addConsumption(ConsumptionBean consumptionBean);

    boolean addRechargeList(ArrayList<RechargeBean> rechargeBean);

    boolean addConsumptionList(ArrayList<ConsumptionBean> consumptionBean);

    void updateAmount(Double amount, String memberUuid);

    void upConsumptionBean(double v, String memberUuid);

    void updateParkingRecordBean(ParkingRecordBean parkingRecordBean);

    ArrayList<RechargeBean> loadRechargeRecordList(String uuid);

    ArrayList<RechargeBean> loadRechargeRecordListByM(String uuid);
}
