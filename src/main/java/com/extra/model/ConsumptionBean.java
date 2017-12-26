package com.extra.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Extra on 2017/11/8.
 * GitHub cnhttt@163.com
 * Work to SZFP
 */
public class ConsumptionBean implements Serializable {
    private Long id;
    private String memberUuid;
    private String memberLPM;
    private String memberName;


    private String  tsn;

    private double rAmount;
    private double bAmount;
    private double aAmount;
    private String operateNumber;
    private String operateUuid;
    private  String deviceSN;
    private String deviceNumber;
    private String companyUuid;
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

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getTsn() {
        return tsn;
    }

    public void setTsn(String tsn) {
        this.tsn = tsn;
    }

    public double getrAmount() {
        return rAmount;
    }

    public void setrAmount(double rAmount) {
        this.rAmount = rAmount;
    }

    public double getbAmount() {
        return bAmount;
    }

    public void setbAmount(double bAmount) {
        this.bAmount = bAmount;
    }

    public double getaAmount() {
        return aAmount;
    }

    public void setaAmount(double aAmount) {
        this.aAmount = aAmount;
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
