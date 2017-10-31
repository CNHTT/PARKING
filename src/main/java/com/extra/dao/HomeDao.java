package com.extra.dao;

import com.extra.model.CompanyInformationBean;
import org.springframework.stereotype.Repository;

/**
 * Created by Extra on 2017/10/31.
 * GitHub cnhttt@163.com
 * Work to SZFP
 */
@Repository
public interface HomeDao {
    CompanyInformationBean selcetCompanyFormUUID(String uuid);
}
