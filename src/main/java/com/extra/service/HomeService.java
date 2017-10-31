package com.extra.service;

import com.extra.model.CompanyInformationBean;

/**
 * Created by Extra on 2017/10/31.
 * GitHub cnhttt@163.com
 * Work to SZFP
 */
public interface HomeService {
    CompanyInformationBean  getCompanyInformationByUUID(String uuid);
}
