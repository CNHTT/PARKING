package com.extra.service.impl;

import com.extra.dao.HomeDao;
import com.extra.dao.ParkingDao;
import com.extra.model.*;
import com.extra.model.response.ResponsePage;
import com.extra.service.HomeService;
import com.extra.utils.BeanUtils;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by Extra on 2017/10/31.
 * GitHub cnhttt@163.com
 * Work to SZFP
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class HomeServiceImpl implements HomeService {

    @Resource
    private HomeDao homeDao;

    @Resource
    private ParkingDao parkingDao;

    @Override
    public CompanyInformationBean getCompanyInformationByUUID(String uuid) {
        return homeDao.selectCompanyFormUUID(uuid);
    }

    @Override
    public ResponsePage<DeviceBean> loadAllDevice(String companyUUID, Integer pageName) {
        pageName = pageName==null?1:pageName;
        PageHelper.startPage(pageName,10);
        return BeanUtils.toResponseResult(homeDao.selectDeviceList(companyUUID));
    }

    @Override
    public ParkingLotBean loadParkingBy(String parkingUuid) {
        return parkingDao.selectParkingLotByUUID(parkingUuid);
    }

    @Override
    public DeviceBean loadDeviceBySn(String sn, String companyUUID) {
        return homeDao.selectDeviceBySn(sn,companyUUID);
    }

    @Override
    public StatisticsBean getTotalParking() {
        return homeDao.selectTotalParking();
    }

    @Override
    public StatisticsBean getTodayParking() {
        return homeDao.selectTodayParking();
    }

    @Override
    public StatisticsBean getYesterdayParking() {
        return homeDao.selectYesterdayParking();
    }

    @Override
    public StatisticsBean getThisWeekParking() {
        return homeDao.selectThisWeekParking() ;
    }

    @Override
    public StatisticsBean getThisMonthParking() {
        return homeDao.selectThisMonthParking();
    }

    @Override
    public int getTotalNumber(String companyUUID) {
        return homeDao.selectDeviceCountFromCompany(companyUUID);
    }

    @Override
    public void addDevice(DeviceBean deviceBean) {
        homeDao.addDevice(deviceBean);
    }

}
