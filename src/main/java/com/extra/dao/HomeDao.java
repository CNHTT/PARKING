package com.extra.dao;

import com.extra.model.CompanyInformationBean;
import com.extra.model.CompanyLotBean;
import com.extra.model.DeviceBean;
import com.extra.model.StatisticsBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * Created by Extra on 2017/10/31.
 * GitHub cnhttt@163.com
 * Work to SZFP
 */
@Repository
public interface HomeDao {
    CompanyInformationBean selectCompanyFormUUID(String uuid);

    ArrayList<DeviceBean> selectDeviceList(String companyUUID);

    DeviceBean selectDeviceBySn(@Param("sn") String sn,@Param("companyUUID") String companyUUID);

    StatisticsBean selectTotalParking();

    StatisticsBean selectTodayParking();

    StatisticsBean selectYesterdayParking();

    StatisticsBean selectThisWeekParking();

    StatisticsBean selectThisMonthParking();

    int selectDeviceCountFromCompany(String companyUUID);

    void addDevice(DeviceBean deviceBean);
}
