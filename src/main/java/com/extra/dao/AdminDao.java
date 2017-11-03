package com.extra.dao;

import com.extra.model.ManagerBean;
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
}
