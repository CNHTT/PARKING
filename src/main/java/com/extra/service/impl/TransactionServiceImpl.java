package com.extra.service.impl;

import com.extra.dao.TransactionDao;
import com.extra.model.ConsumptionBean;
import com.extra.model.RechargeBean;
import com.extra.model.response.ResponsePage;
import com.extra.service.TransactionService;
import com.extra.utils.BeanUtils;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;

@Service
@Transactional(rollbackFor =  Exception.class)
public class TransactionServiceImpl implements TransactionService {


    @Resource
    private TransactionDao transactionDao;



    @Override
    public ResponsePage<RechargeBean> loadRechargeList(String companyUUID, Integer pageName) {
        pageName  = pageName ==null?1:pageName;
        PageHelper.startPage(pageName,10);
        return BeanUtils.toResponseResult(transactionDao.selectRechargeList(companyUUID));
    }

    @Override
    public ResponsePage<RechargeBean> loadRechargeListByLPM(String companyUUID, Integer pageName, String lpm) {
        pageName  = pageName ==null?1:pageName;
        PageHelper.startPage(pageName,10);
        return BeanUtils.toResponseResult(transactionDao.selectRechargeListByLPM(companyUUID,lpm));
    }

    @Override
    public ResponsePage<ConsumptionBean> loadConsumptionList(String companyUUID, Integer pageName) {
        pageName  = pageName ==null?1:pageName;
        PageHelper.startPage(pageName,10);
        return  BeanUtils.toResponseResult(transactionDao.selectConsumptionByLPM(companyUUID));
    }

    @Override
    public boolean addRecharge(RechargeBean rechargeBean) {
        return transactionDao.insertRecharge(rechargeBean)!=0;
    }

    @Override
    public boolean addConsumption(ConsumptionBean consumptionBean) {
        return transactionDao.insertConsumptionBean(consumptionBean)!=0;
    }

    @Override
    public boolean addRechargeList(ArrayList<RechargeBean> rechargeBean) {
        return transactionDao.insertRechargeList(rechargeBean)!=0;
    }

    @Override
    public boolean addConsumptionList(ArrayList<ConsumptionBean> consumptionBean) {
        return transactionDao.insertConsumptionList(consumptionBean)!=0;
    }

    @Override
    public void updateAmount(Double amount, String memberUuid) {
        transactionDao.updateAmount(amount,memberUuid);
    }
}
