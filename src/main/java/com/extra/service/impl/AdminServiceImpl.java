package com.extra.service.impl;

import com.extra.dao.AdminDao;
import com.extra.model.ManagerBean;
import com.extra.model.response.ResponsePage;
import com.extra.service.AdminService;
import com.extra.utils.BeanUtils;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by Extra on 2017/11/3.
 * GitHub cnhttt@163.com
 * Work to SZFP
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class AdminServiceImpl implements AdminService{
    @Resource
    private AdminDao adminDao;

    @Override
    public ResponsePage<ManagerBean> loadParkingLotList(String companyUUID, Integer pageName, Integer limitName) {
        pageName    =  pageName ==null?1:pageName;
        limitName     =  limitName  ==null?10:limitName;
        PageHelper.startPage(pageName,limitName);
        return BeanUtils.toResponseResult(adminDao.selectAdministratorList(companyUUID));
    }
}
