package com.extra.controller;

import com.extra.model.ManagerBean;
import com.extra.model.ParkingLotBean;
import com.extra.model.response.ResponsePage;
import com.extra.service.ParkingService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import static com.extra.utils.SessionUtils.SESSION_MANAGER;

/**
 * Created by Extra on 2017/10/30.
 * GitHub cnhttt@163.com
 * Work to SZFP
 */
@Controller
public class ParkingController extends  BaseController {


    @Resource
    private ParkingService parkingService;



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



    @RequestMapping("parking_lot_add")
    public  String toParkingLotAddJsp(){return "parking-lot-add";}



    @RequestMapping(value ="parkingLot/list" )
    @ResponseBody
    public String getParkingLotList(Integer pageName,Integer limitName,HttpServletRequest req){

        try {
            ManagerBean managerBean = (ManagerBean) req.getSession().getAttribute(SESSION_MANAGER);
            log.info("分页查询ParkingLotList信息"+managerBean.getUserName());
            if (managerBean==null)return responseFail("No");
            ResponsePage<ParkingLotBean> responsePage =
                    parkingService.loadParkingLotList(managerBean.getCompanyUUID(),pageName,limitName);
            return responseResult(responsePage);
        }catch (Exception e){
            return responseFail(e.toString());
        }
    }



}
