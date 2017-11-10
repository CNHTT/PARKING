package com.extra.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Extra on 2017/11/6.
 * GitHub cnhttt@163.com
 * Work to SZFP
 */
public class MemberBean implements Serializable {
    private Long id;
    private String name;
    private int sex;
    private String number;
    private String phone;
    private String email;
    private String contactAddress;
    private int status;
    private String lpm;
    private int is_del;
    private double balance;
    private String companyUuid;
    private String  uuid;
    private String  addManagerUuid;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    private Date createTime;
    private String cardId;


    public String getNumber() {
        return number;
    }


    public String getLpm() {
        return lpm;
    }

    public void setLpm(String lpm) {
        this.lpm = lpm;
    }

    public void setNumber(String number) {
        this.number = number;
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

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

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

    public String getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getIs_del() {
        return is_del;
    }

    public void setIs_del(int is_del) {
        this.is_del = is_del;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCompanyUuid() {
        return companyUuid;
    }

    public void setCompanyUuid(String companyUuid) {
        this.companyUuid = companyUuid;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getAddManagerUuid() {
        return addManagerUuid;
    }

    public void setAddManagerUuid(String addManagerUuid) {
        this.addManagerUuid = addManagerUuid;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }
}
