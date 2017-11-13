package com.extra.service.impl;

import com.extra.dao.ParkingDao;
import com.extra.model.ParkingLotBean;
import com.extra.model.ParkingRecordBean;
import com.extra.model.response.ResponsePage;
import com.extra.service.ParkingService;
import com.extra.utils.BeanUtils;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;

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

    @Override
    public int getTotalNumber(String companyUuid) {
        return parkingDao.selectParkingLotCount(companyUuid);
    }

    @Override
    public boolean addParkingLot(ParkingLotBean lotBean) {
        return parkingDao.insertParkingLot(lotBean) !=0;
    }

    @Override
    public ArrayList<ParkingLotBean> loadParkingLotList(String companyUUID) {
        return parkingDao.selectParkingLotList(companyUUID);
    }

    @Override
    public ResponsePage<ParkingRecordBean> loadAllParkingRecordList(String parkingUuid, Integer pageName) {
        pageName = pageName==null?1:pageName;
        PageHelper.startPage(pageName,10);
        return BeanUtils.toResponseResult(parkingDao.selectParkingRecordAllList(parkingUuid));
    }

    @Override
    public ResponsePage<ParkingRecordBean> loadAllParkingRecordListByLpm(String companyUUID, Integer pageName, String lpm) {
        pageName = pageName==null?1:pageName;
        PageHelper.startPage(pageName,10);
        return BeanUtils.toResponseResult(parkingDao.selectParkingRecordByLpmAllList(companyUUID,lpm));
    }

    @Override
    public ResponsePage<ParkingRecordBean> loadAllParkingUndoneList(String companyUUID, Integer pageName) {
        pageName = pageName==null?1:pageName;
        PageHelper.startPage(pageName,10);
        return BeanUtils.toResponseResult(parkingDao.selectParkingUndoneAllList(companyUUID));
    }

    @Override
    public ResponsePage<ParkingRecordBean> loadAllParkingUndoneByLpmList(String companyUUID, Integer pageName, String lpm) {
        pageName = pageName==null?1:pageName;
        PageHelper.startPage(pageName,10);
        return BeanUtils.toResponseResult(parkingDao.selectParkingUndoneByLpmList(companyUUID,lpm));
    }

    @Override
    public ResponsePage<ParkingRecordBean> loadAllParkingCompletedList(String companyUUID, Integer pageName) {
        pageName = pageName==null?1:pageName;
        PageHelper.startPage(pageName,10);
        return BeanUtils.toResponseResult(parkingDao.selectParkingCompletedAllList(companyUUID));
    }

    @Override
    public ResponsePage<ParkingRecordBean> loadAllParkingCompletedByLpmList(String companyUUID, Integer pageName, String lpm) {
        pageName = pageName==null?1:pageName;
        PageHelper.startPage(pageName,10);
        return BeanUtils.toResponseResult(parkingDao.selectParkingCompletedByLpmList(companyUUID,lpm));
    }

    @Override
    public boolean addParkingRecordBean(ParkingRecordBean parkingRecordBean) {
        return parkingDao.insertParkingRecord(parkingRecordBean)!=0;
    }

    @Override
    public boolean addParkingRecordList(ArrayList<ParkingRecordBean> parkingRecordBeans) {
        return parkingDao.insertParkingRecordList(parkingRecordBeans)!=0;
    }

    @Override
    public boolean addParkingRecordEntry(ParkingRecordBean parkingRecordBean) {
        return parkingDao.insertParkingEntry(parkingRecordBean)!=0;
    }

    @Override
    public boolean addParkingRecordEntryList(ArrayList<ParkingRecordBean> parkingRecordBeans) {
        return parkingDao.insertParkingRecordEntryList(parkingRecordBeans)!=0;
    }
}
