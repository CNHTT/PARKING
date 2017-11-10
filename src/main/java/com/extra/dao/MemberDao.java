package com.extra.dao;

import com.extra.model.MemberBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Member;
import java.util.ArrayList;

/**
 * Created by Extra on 2017/11/7.
 * GitHub cnhttt@163.com
 * Work to SZFP
 */
@Repository
public interface MemberDao {
    ArrayList<MemberBean> selectMemberList(String companyUUID);

    MemberBean selectMemberFromUuid(String uuid);

    ArrayList<MemberBean> selectMemberFromLPM(@Param("companyUUID") String companyUUID, @Param("lpm") String lpm);

    ArrayList<MemberBean> selectMemberDelList(String companyUUID);

    ArrayList<MemberBean> selectMemberDelFromLPM(@Param("companyUUID") String companyUUID, @Param("lpm") String lpm);

    int insertMember(MemberBean memberBean);
}
