package com.extra.dao;

import com.extra.model.ManagerBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * Created by Extra on 2017/11/3.
 * GitHub cnhttt@163.com
 * Work to SZFP
 */
@Repository
public interface AdminDao {
    ArrayList<ManagerBean> selectAdministratorList(String companyUuid);

    int selectManagerCountFromCompany(String companyUUID);

    int insertManager(ManagerBean managerBean);

    ArrayList<ManagerBean> selectAdministratorListFromName(@Param("companyUuid") String companyUUID,@Param("name") String name);
}
