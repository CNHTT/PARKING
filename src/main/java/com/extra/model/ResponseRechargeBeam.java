package com.extra.model;

import com.extra.model.response.ResponseObj;

/**
 * Created by Extra on 2017/11/13.
 * GitHub cnhttt@163.com
 * Work to SZFP
 */
public class ResponseRechargeBeam extends ResponseObj {
   private MemberBean memberBean;
   private RechargeBean rechargeBean;


    public MemberBean getMemberBean() {
        return memberBean;
    }

    public void setMemberBean(MemberBean memberBean) {
        this.memberBean = memberBean;
    }

    public RechargeBean getRechargeBean() {
        return rechargeBean;
    }

    public void setRechargeBean(RechargeBean rechargeBean) {
        this.rechargeBean = rechargeBean;
    }
}
