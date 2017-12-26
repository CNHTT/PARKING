package com.extra.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Extra on 2017/11/8.
 * GitHub cnhttt@163.com
 * Work to SZFP
 */
public class ParkingRecordBean implements Serializable{

    private  Long id;
    private  String  tsn;
    private  int  type;
    private  String memberUuid;
    private  String memberName;
    private  String memberLpm;
    private String operateNumber;
    private String operateUuid;
    private String deviceSN;
    private String deviceNumber;
    private String companyUuid;

    private String phone;
    private String email;


    private String parkingLotName;
    private String parkingUuid;


    private double amount;
    //驶入时间
    private long enterLongTime;
    //驶出时间
    private long exitLongTime;

    private Date enterTime;
    private Date exitTime;

    private Date createTime;
    private long parkingTime;
    private int intTime;







    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompanyUuid() {
        return companyUuid;
    }

    public void setCompanyUuid(String companyUuid) {
        this.companyUuid = companyUuid;
    }

    public String getParkingLotName() {
        return parkingLotName;
    }

    public void setParkingLotName(String parkingLotName) {
        this.parkingLotName = parkingLotName;
    }

    public String getParkingUuid() {
        return parkingUuid;
    }

    public void setParkingUuid(String parkingUuid) {
        this.parkingUuid = parkingUuid;
    }

    public Long getId() {
        return id;
    }

    private double rAmount;
    private double bAmount;
    private double aAmount;

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


    public void setId(Long id) {
        this.id = id;
    }

    public String getTsn() {
        return tsn;
    }

    public void setTsn(String tsn) {
        this.tsn = tsn;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getMemberUuid() {
        return memberUuid;
    }

    public void setMemberUuid(String memberUuid) {
        this.memberUuid = memberUuid;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberLpm() {
        return memberLpm;
    }

    public void setMemberLpm(String memberLpm) {
        this.memberLpm = memberLpm;
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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public long getEnterLongTime() {
        return enterLongTime;
    }

    public void setEnterLongTime(long enterLongTime) {
        this.enterLongTime = enterLongTime;
    }

    public long getExitLongTime() {
        return exitLongTime;
    }

    public void setExitLongTime(long exitLongTime) {
        this.exitLongTime = exitLongTime;
    }

    public Date getEnterTime() {
        return enterTime;
    }

    public void setEnterTime(Date enterTime) {
        this.enterTime = enterTime;
    }

    public Date getExitTime() {
        return exitTime;
    }

    public void setExitTime(Date exitTime) {
        this.exitTime = exitTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public long getParkingTime() {
        return parkingTime;
    }

    public void setParkingTime(long parkingTime) {
        this.parkingTime = parkingTime;
    }

    public int getIntTime() {
        return intTime;
    }

    public void setIntTime(int intTime) {
        this.intTime = intTime;
    }
}
