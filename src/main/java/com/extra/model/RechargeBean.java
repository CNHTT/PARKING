package com.extra.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Extra on 2017/11/7.
 * GitHub cnhttt@163.com
 * Work to SZFP
 */
public class RechargeBean implements Serializable{
    private Long id;
    private String memberUuid;
    private String memberLPM;
    private String  tsn;

    private double rAmont;
    private double bAmont;
    private double aAmont;
    private String operateNumber;
    private String operateUuid;
    private  String deviceSN;
    private String deviceNumber;
    private String companyUuid;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMemberUuid() {
        return memberUuid;
    }

    public void setMemberUuid(String memberUuid) {
        this.memberUuid = memberUuid;
    }

    public String getMemberLPM() {
        return memberLPM;
    }

    public void setMemberLPM(String memberLPM) {
        this.memberLPM = memberLPM;
    }

    public String getTsn() {
        return tsn;
    }

    public void setTsn(String tsn) {
        this.tsn = tsn;
    }

    public double getrAmont() {
        return rAmont;
    }

    public void setrAmont(double rAmont) {
        this.rAmont = rAmont;
    }

    public double getaAmont() {
        return aAmont;
    }


    public double getbAmont() {
        return bAmont;
    }

    public void setbAmont(double bAmont) {
        this.bAmont = bAmont;
    }

    public void setaAmont(double aAmont) {
        this.aAmont = aAmont;
    }

    public String getOperateNumber() {
        return operateNumber;
    }

    public void setOperateNumber(String operateNumber) {
        this.operateNumber = operateNumber;
    }

    public String getOperateUuid() {
        return operateUuid;
    }

    public void setOperateUuid(String operateUuid) {
        this.operateUuid = operateUuid;
    }

    public String getDeviceSN() {
        return deviceSN;
    }

    public void setDeviceSN(String deviceSN) {
        this.deviceSN = deviceSN;
    }

    public String getDeviceNumber() {
        return deviceNumber;
    }

    public void setDeviceNumber(String deviceNumber) {
        this.deviceNumber = deviceNumber;
    }

    public String getCompanyUuid() {
        return companyUuid;
    }

    public void setCompanyUuid(String companyUuid) {
        this.companyUuid = companyUuid;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
