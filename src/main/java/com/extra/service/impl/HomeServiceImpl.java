package com.extra.service.impl;

import com.extra.dao.HomeDao;
import com.extra.model.CompanyInformationBean;
import com.extra.service.HomeService;
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

    @Override
    public CompanyInformationBean getCompanyInformationByUUID(String uuid) {
        return homeDao.selcetCompanyFormUUID(uuid);
    }
}
