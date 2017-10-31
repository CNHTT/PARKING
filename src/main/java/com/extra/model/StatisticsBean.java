package com.extra.model;

/**
 * Created by Extra on 2017/10/31.
 * GitHub cnhttt@163.com
 * Work to SZFP
 * 统计
 */
public class StatisticsBean {

    private  String parkingStatistics= "0";
    private  String parkingIncome= "0";
    private  String rechargeStatistics= "0";
    private  String rechargeIncome= "0";
    private  String user= "0";
    private  String administrator= "0";

    public String getParkingStatistics() {
        return parkingStatistics;
    }

    public void setParkingStatistics(String parkingStatistics) {
        this.parkingStatistics = parkingStatistics;
    }

    public String getParkingIncome() {
        return parkingIncome;
    }

    public void setParkingIncome(String parkingIncome) {
        this.parkingIncome = parkingIncome;
    }

    public String getRechargeStatistics() {
        return rechargeStatistics;
    }

    public void setRechargeStatistics(String rechargeStatistics) {
        this.rechargeStatistics = rechargeStatistics;
    }

    public String getRechargeIncome() {
        return rechargeIncome;
    }

    public void setRechargeIncome(String rechargeIncome) {
        this.rechargeIncome = rechargeIncome;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getAdministrator() {
        return administrator;
    }

    public void setAdministrator(String administrator) {
        this.administrator = administrator;
    }
}
