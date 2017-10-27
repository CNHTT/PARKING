package com.extra.service;

import com.extra.model.ManagerBean;

/**
 * Created by Extra on 2017/10/27.
 * GitHub cnhttt@163.com
 * Work to SZFP
 */
public interface LoginService {
    ManagerBean getManagerInfo(String username,String pwd);
}
