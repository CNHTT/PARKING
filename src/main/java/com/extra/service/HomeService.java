package com.extra.service;

import com.extra.model.*;
import com.extra.model.response.ResponsePage;

/**
 * Created by Extra on 2017/10/31.
 * GitHub cnhttt@163.com
 * Work to SZFP
 */
public interface HomeService {
    CompanyInformationBean  getCompanyInformationByUUID(String uuid);

    ResponsePage<DeviceBean> loadAllDevice(String companyUUID, Integer pageName);

    ParkingLotBean loadParkingBy(String parkingUuid);

    DeviceBean loadDeviceBySn(String sn, String companyUUID);

    StatisticsBean getTotalParking();

    StatisticsBean getTodayParking();

    StatisticsBean getYesterdayParking();

    StatisticsBean getThisWeekParking();

    StatisticsBean getThisMonthParking();

    int getTotalNumber(String companyUUID);

    void addDevice(DeviceBean deviceBean);
}
