package com.extra.service.impl;

import com.extra.dao.UserDao;
import com.extra.model.ManagerBean;
import com.extra.service.LoginService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by Extra on 2017/10/27.
 * GitHub cnhttt@163.com
 * Work to SZFP
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class LoginServiceImpl implements LoginService {

    @Resource
    private UserDao userDao;

    @Override
    public ManagerBean getManagerInfo(String username, String pwd) {
        return userDao.selectManagerBySignIn(username,pwd);
    }
}
