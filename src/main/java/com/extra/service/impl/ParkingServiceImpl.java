package com.extra.service.impl;

import com.extra.dao.ParkingDao;
import com.extra.model.ParkingLotBean;
import com.extra.model.response.ResponsePage;
import com.extra.service.ParkingService;
import com.extra.utils.BeanUtils;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by Extra on 2017/11/1.
 * GitHub cnhttt@163.com
 * Work to SZFP
 */
@Service
@Transactional(rollbackFor =  Exception.class)
public class ParkingServiceImpl implements ParkingService {

    @Resource
    private ParkingDao parkingDao;

    @Override
    public ResponsePage<ParkingLotBean> loadParkingLotList(String companyUUID, Integer pageName, Integer limitName) {
        pageName    =  pageName ==null?1:pageName;
        limitName     =  limitName  ==null?10:limitName;
        PageHelper.startPage(pageName,limitName);
        return BeanUtils.toResponseResult(parkingDao.selectParkingLotList(companyUUID));
    }
}
