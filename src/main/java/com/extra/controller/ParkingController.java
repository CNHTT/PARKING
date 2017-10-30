package com.extra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Extra on 2017/10/30.
 * GitHub cnhttt@163.com
 * Work to SZFP
 */
@Controller
public class ParkingController extends  BaseController {

    @RequestMapping("parking_records")
    public  String parkingRecords(){
        return "parking-records";
    }
    @RequestMapping("parking_abnormal")
    public  String parkingAbnormal(){
        return "parking-abnormal";
    }
    @RequestMapping("parking_completed")
    public  String parkingCompleted(){
        return "parking-completed";
    }
    @RequestMapping("parking_undone")
    public  String parkingUndone(){
        return "parking-undone";
    }








    @RequestMapping("parking_management")
    public  String parkingManagement(){return "parking-management";}





}
