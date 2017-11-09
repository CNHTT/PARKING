package com.extra.dao;

import com.extra.model.CompanyInformationBean;
import com.extra.model.CompanyLotBean;
import com.extra.model.DeviceBean;
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

}
