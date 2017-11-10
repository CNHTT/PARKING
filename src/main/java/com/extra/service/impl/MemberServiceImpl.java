package com.extra.service.impl;

import com.extra.dao.MemberDao;
import com.extra.model.MemberBean;
import com.extra.model.response.ResponsePage;
import com.extra.service.MemberService;
import com.extra.utils.BeanUtils;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.lang.reflect.Member;

/**
 * Created by Extra on 2017/11/7.
 * GitHub cnhttt@163.com
 * Work to SZFP
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class MemberServiceImpl implements MemberService {

    @Resource
    private MemberDao memberDao;

    @Override
    public ResponsePage<MemberBean> loadMemberList(String companyUUID, Integer pageName) {
        pageName    =  pageName ==null?1:pageName;
        PageHelper.startPage(pageName,10);
        return BeanUtils.toResponseResult(memberDao.selectMemberList(companyUUID));
    }

    @Override
    public MemberBean loadMemberFromUUID(String uuid) {
        return memberDao.selectMemberFromUuid(uuid);
    }

    @Override
    public ResponsePage<MemberBean> loadMemberFromLPM(String companyUUID, String lpm) {
        PageHelper.startPage(1,20);
        return BeanUtils.toResponseResult(memberDao.selectMemberFromLPM(companyUUID,lpm));
    }

    @Override
    public ResponsePage<MemberBean> loadMemberDelList(String companyUUID, Integer pageName) {
        pageName    =  pageName ==null?1:pageName;
        PageHelper.startPage(pageName,10);
        return BeanUtils.toResponseResult(memberDao.selectMemberDelList(companyUUID));
    }

    @Override
    public ResponsePage<MemberBean> loadMemberDelFromLPM(String companyUUID, String lpm) {
        PageHelper.startPage(1,20);
        return BeanUtils.toResponseResult(memberDao.selectMemberDelFromLPM(companyUUID,lpm));
    }

    @Override
    public boolean addMember(MemberBean memberBean) {
        return memberDao.insertMember(memberBean)!=0;
    }


}
