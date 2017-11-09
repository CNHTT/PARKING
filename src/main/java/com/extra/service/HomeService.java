package com.extra.service;

import com.extra.model.CompanyInformationBean;
import com.extra.model.CompanyLotBean;
import com.extra.model.DeviceBean;
import com.extra.model.ParkingLotBean;
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
}
