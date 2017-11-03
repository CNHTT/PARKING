package com.extra.service;

import com.extra.model.ManagerBean;
import com.extra.model.ParkingLotBean;
import com.extra.model.response.ResponsePage;

/**
 * Created by Extra on 2017/11/3.
 * GitHub cnhttt@163.com
 * Work to SZFP
 */
public interface AdminService {
    ResponsePage<ManagerBean> loadParkingLotList(String companyUUID, Integer pageName, Integer limitName);
}
