package com.extra.controller;

import com.extra.model.ManagerBean;
import com.extra.model.ParkingLotBean;
import com.extra.model.ParkingRecordBean;
import com.extra.model.response.ResponsePage;
import com.extra.service.ParkingService;
import com.extra.utils.TimeUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
    public  String parkingRecords(HttpServletRequest req, ModelMap model ,Integer pageName){
        ResponsePage<ParkingRecordBean> page = new ResponsePage<>();

        try {
            ManagerBean managerBean = (ManagerBean) req.getSession().getAttribute(SESSION_MANAGER);
            log.info("parkingRecords:"+ managerBean.getClass()+managerBean.toString());
            page = parkingService.loadAllParkingRecordList(managerBean.getCompanyUUID(),pageName);

        }catch (Exception e){
            log.info("parkingRecords:"+e.toString());
        }
        model.addAttribute("page",page);
        return "parking-records";
    }

    @RequestMapping("parking.records.lpm")
    public  String parkingRecordsByLPM(HttpServletRequest req, ModelMap model ,Integer pageName,String lpm){
        ResponsePage<ParkingRecordBean> page = new ResponsePage<>();

        try {
            ManagerBean managerBean = (ManagerBean) req.getSession().getAttribute(SESSION_MANAGER);
            log.info("parkingRecords:"+ managerBean.getClass()+managerBean.toString());
            page = parkingService.loadAllParkingRecordListByLpm(managerBean.getCompanyUUID(),pageName,lpm);

        }catch (Exception e){
            log.info("parkingRecords:"+e.toString());
        }
        model.addAttribute("page",page);
        return "parking-records";
    }


    @RequestMapping("parking_undone")
    public  String parkingUndone(HttpServletRequest req, ModelMap model ,Integer pageName){
        ResponsePage<ParkingRecordBean> page = new ResponsePage<>();

        try {
            ManagerBean managerBean = (ManagerBean) req.getSession().getAttribute(SESSION_MANAGER);
            log.info("Undone:"+ managerBean.getClass()+managerBean.toString());
            page = parkingService.loadAllParkingUndoneList(managerBean.getCompanyUUID(),pageName);

        }catch (Exception e){
            log.info("parkingRecords:"+e.toString());
        }
        model.addAttribute("page",page);
        return "parking-undone";
    }

    @RequestMapping("undone.lpm")
    public  String parkingUndoneByLpm(HttpServletRequest req, ModelMap model ,Integer pageName,String lpm){
        ResponsePage<ParkingRecordBean> page = new ResponsePage<>();

        try {
            ManagerBean managerBean = (ManagerBean) req.getSession().getAttribute(SESSION_MANAGER);
            log.info("Undone:"+ managerBean.getClass()+managerBean.toString());
            page = parkingService.loadAllParkingUndoneByLpmList(managerBean.getCompanyUUID(),pageName,lpm);

        }catch (Exception e){
            log.info("parkingRecords:"+e.toString());
        }
        model.addAttribute("page",page);
        return "parking-undone";
    }

    @RequestMapping("parking_completed")
    public  String parkingCompleted(HttpServletRequest req, ModelMap model ,Integer pageName){
        ResponsePage<ParkingRecordBean> page = new ResponsePage<>();

        try {
            ManagerBean managerBean = (ManagerBean) req.getSession().getAttribute(SESSION_MANAGER);
            log.info("Undone:"+ managerBean.getClass()+managerBean.toString());
            page = parkingService.loadAllParkingCompletedList(managerBean.getCompanyUUID(),pageName);

        }catch (Exception e){
            log.info("parkingRecords:"+e.toString());
        }
        model.addAttribute("page",page);
        return "parking-completed";
    }

    @RequestMapping("completed.lpm")
    public  String parkingCompletedByLpm(HttpServletRequest req, ModelMap model ,Integer pageName,String lpm){
        ResponsePage<ParkingRecordBean> page = new ResponsePage<>();

        try {
            ManagerBean managerBean = (ManagerBean) req.getSession().getAttribute(SESSION_MANAGER);
            log.info("Undone:"+ managerBean.getClass()+managerBean.toString());
            page = parkingService.loadAllParkingCompletedByLpmList(managerBean.getCompanyUUID(),pageName,lpm);

        }catch (Exception e){
            log.info("parkingRecords:"+e.toString());
        }
        model.addAttribute("page",page);
        return "parking-undone";
    }

    @RequestMapping("parking_abnormal")
    public  String parkingAbnormal(){
        return "parking-abnormal";
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
@RequestMapping(value = "addParkingLot")
    public String addParkingLot(ParkingLotBean lotBean,HttpServletRequest req){
        ManagerBean managerBean = (ManagerBean) req.getSession().getAttribute(SESSION_MANAGER);
        log.info(lotBean.toString());
        String number = TimeUtils.getUniqueNumber( parkingService.getTotalNumber(managerBean.getCompanyUUID()));
        lotBean.setNumber(number);
        lotBean.setUuid(TimeUtils.getUUID());
        lotBean.setCompanyUuid(managerBean.getCompanyUUID());
        lotBean.setAddMangerUuid(managerBean.getUUID());
        if (parkingService.addParkingLot(lotBean))
        return  "redirect:success";
        return "redirect:parking_lot_add";
    }


    @RequestMapping("success")
    public String success(){return "add-success";}

}
