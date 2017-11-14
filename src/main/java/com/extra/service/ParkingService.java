package com.extra.service;

import com.extra.model.ParkingLotBean;
import com.extra.model.ParkingRecordBean;
import com.extra.model.response.ResponsePage;

import java.util.ArrayList;

/**
 * Created by Extra on 2017/11/1.
 * GitHub cnhttt@163.com
 * Work to SZFP
 */
public interface ParkingService {
    ResponsePage<ParkingLotBean> loadParkingLotList(String companyUUID, Integer pageName, Integer limitName);
    int getTotalNumber(String companyUuid);
    boolean addParkingLot(ParkingLotBean lotBean);
    ArrayList<ParkingLotBean> loadParkingLotList(String companyUUID);
    ResponsePage<ParkingRecordBean> loadAllParkingRecordList(String parkingUuid, Integer pageName);

    ResponsePage<ParkingRecordBean> loadAllParkingRecordListByLpm(String companyUUID, Integer pageName, String lpm);

    ResponsePage<ParkingRecordBean> loadAllParkingUndoneList(String companyUUID, Integer pageName);

    ResponsePage<ParkingRecordBean> loadAllParkingUndoneByLpmList(String companyUUID, Integer pageName, String lpm);

    ResponsePage<ParkingRecordBean> loadAllParkingCompletedList(String companyUUID, Integer pageName);

    ResponsePage<ParkingRecordBean> loadAllParkingCompletedByLpmList(String companyUUID, Integer pageName, String lpm);

    boolean addParkingRecordBean(ParkingRecordBean parkingRecordBean);

    boolean addParkingRecordList(ArrayList<ParkingRecordBean> parkingRecordBeans);

    boolean addParkingRecordEntry(ParkingRecordBean parkingRecordBean);

    boolean addParkingRecordEntryList(ArrayList<ParkingRecordBean> parkingRecordBeans);

    ArrayList<ParkingLotBean> loadParkingRecordByMember(String memberUUid);
}
