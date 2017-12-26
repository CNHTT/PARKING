package com.extra.dao;

import com.extra.model.ConsumptionBean;
import com.extra.model.ParkingRecordBean;
import com.extra.model.RechargeBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface TransactionDao {
    ArrayList<RechargeBean> selectRechargeList(String companyUUID);

    ArrayList<RechargeBean> selectRechargeListByLPM(@Param("companyUUID") String companyUUID, @Param("lpm")String lpm);

    ArrayList<ConsumptionBean> selectConsumptionByLPM(String companyUUID);

    int insertRecharge(RechargeBean rechargeBean);

    int insertConsumptionBean(ConsumptionBean consumptionBean);

    int insertRechargeList(ArrayList<RechargeBean> list);

    int insertConsumptionList(ArrayList<ConsumptionBean> list);

    void updateAmount(@Param("amount") Double amount, @Param("uuid") String memberUuid);

    void upConsumptionAmount(@Param("amount")double v,@Param("uuid") String memberUuid);

    void updateParkingRecord(ParkingRecordBean parkingRecordBean);

    ArrayList<RechargeBean> loadRechargeRecordList(String companyUUID);

    ArrayList<RechargeBean> loadRechargeRecordListByM(String uuid);
}
