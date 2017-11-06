package com.extra.service;

import com.extra.model.ParkingLotBean;
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
}
