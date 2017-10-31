package com.extra.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * Created by Extra on 2017/10/30.
 * GitHub cnhttt@163.com
 * Work to SZFP
 */
public class HomeBean {
    private int loginNum;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    private Date time;
    private String ip;


    private List<StatisticsBean> list;

    public List<StatisticsBean> getList() {
        return list;
    }

    public void setList(List<StatisticsBean> list) {
        this.list = list;
    }

    public int getLoginNum() {
        return loginNum;
    }

    public void setLoginNum(int loginNum) {
        this.loginNum = loginNum;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
