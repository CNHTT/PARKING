package com.extra.service;

import com.extra.model.MemberBean;
import com.extra.model.response.ResponsePage;

import java.lang.reflect.Member;

/**
 * Created by Extra on 2017/11/7.
 * GitHub cnhttt@163.com
 * Work to SZFP
 */
public interface MemberService {
    ResponsePage<MemberBean> loadMemberList(String companyUUID, Integer pageName);
    MemberBean loadMemberFromUUID(String uuid);
    ResponsePage<MemberBean> loadMemberFromLPM(String companyUUID, String lpm);

    ResponsePage<MemberBean> loadMemberDelList(String companyUUID, Integer pageName);

    ResponsePage<MemberBean> loadMemberDelFromLPM(String companyUUID, String lpm);

    boolean addMember(MemberBean memberBean);

    void updateMember(String uuid);

    MemberBean loadMemberFromCardId(String uuid);
}
