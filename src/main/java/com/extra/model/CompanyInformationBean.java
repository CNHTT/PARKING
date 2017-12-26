package com.extra.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * Created by Extra on 2017/10/31.
 * GitHub cnhttt@163.com
 * Work to SZFP
 */
public class CompanyInformationBean {

    private Long id;                                                   //公司ＩＤ
    private String name;                                        // 公司名称
    private String contactNumber;                     // 联系电话
    private String PIC;                                        // 公司负责人
    private String website;                               // 公司网站
    private String email;                                 // 公司邮箱
    private String address;                           //公司地址
    private String managerUUID;              //第一创建人UUID
    private String UUID;                            //公司UUID


    private Date createTime;
    private Date modifyTime;


    private DeviceBean device;


    private List<ParkingLotBean> lotList;


    public DeviceBean getDevice() {
        return device;
    }

    public void setDevice(DeviceBean device) {
        this.device = device;
    }

    public List<ParkingLotBean> getLotList() {
        return lotList;
    }

    public void setLotList(List<ParkingLotBean> lotList) {
        this.lotList = lotList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getPIC() {
        return PIC;
    }

    public void setPIC(String PIC) {
        this.PIC = PIC;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getManagerUUID() {
        return managerUUID;
    }

    public void setManagerUUID(String managerUUID) {
        this.managerUUID = managerUUID;
    }

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
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
}
