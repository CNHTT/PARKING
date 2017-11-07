package com.extra.service.impl;

import com.extra.dao.TransactionDao;
import com.extra.model.RechargeBean;
import com.extra.model.response.ResponsePage;
import com.extra.service.TransactionService;
import com.extra.utils.BeanUtils;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

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
}
