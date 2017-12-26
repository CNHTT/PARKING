package com.extra.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Extra on 2017/10/27.
 * GitHub cnhttt@163.com
 * Work to SZFP
 */
public class ManagerBean implements Serializable {
    private Long id;
    private String userName;
    private String userPhone;
    private String userEmail;
    private String userPwd;
    private String pwdSalt;
    private String site;
    private String cookie;
    private Date createTime;
    private Date modifyTime;
    private String strTime;
    private String uniqueNumber;

    private String parkingLotName;
    private String parkingUuid;

    private String UUID;
    private String companyUUID;
    private  String number;
    private int status;
    private int type;


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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getCompanyUUID() {
        return companyUUID;
    }

    public void setCompanyUUID(String companyUUID) {
        this.companyUUID = companyUUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getPwdSalt() {
        return pwdSalt;
    }

    public void setPwdSalt(String pwdSalt) {
        this.pwdSalt = pwdSalt;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getStrTime() {
        return strTime;
    }

    public void setStrTime(String strTime) {
        this.strTime = strTime;
    }

    public String getUniqueNumber() {
        return uniqueNumber;
    }

    public void setUniqueNumber(String uniqueNumber) {
        this.uniqueNumber = uniqueNumber;
    }

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }


    @Override
    public String toString() {
        return "ManagerBean{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", pwdSalt='" + pwdSalt + '\'' +
                ", site='" + site + '\'' +
                ", cookie='" + cookie + '\'' +
                ", createTime=" + createTime +
                ", modifyTime=" + modifyTime +
                ", strTime='" + strTime + '\'' +
                ", uniqueNumber='" + uniqueNumber + '\'' +
                ", parkingLotName='" + parkingLotName + '\'' +
                ", parkingUuid='" + parkingUuid + '\'' +
                ", UUID='" + UUID + '\'' +
                ", companyUUID='" + companyUUID + '\'' +
                ", number='" + number + '\'' +
                ", status=" + status +
                ", type=" + type +
                '}';
    }
}
