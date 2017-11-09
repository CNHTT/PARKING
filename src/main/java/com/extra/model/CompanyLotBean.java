package com.extra.model;

import java.util.List;

/**
 * Created by Extra on 2017/11/9.
 * GitHub cnhttt@163.com
 * Work to SZFP
 */
public class CompanyLotBean {

    private Long id;
    private String name;
    private String contactNumber;
    private String PIC;
    private String website;
    private String email;
    private String address;
    private String UUID;

    private List<ParkingLotBean> lotList;


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

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public List<ParkingLotBean> getLotList() {
        return lotList;
    }

    public void setLotList(List<ParkingLotBean> lotList) {
        this.lotList = lotList;
    }
}
