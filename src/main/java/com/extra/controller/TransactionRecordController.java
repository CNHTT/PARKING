package com.extra.controller;

import com.extra.model.*;
import com.extra.model.response.ResponseObj;
import com.extra.model.response.ResponsePage;
import com.extra.service.TransactionService;
import com.extra.utils.GsonUtils;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;

import static com.extra.utils.DataUtils.isEmpty;
import static com.extra.utils.SessionUtils.SESSION_MANAGER;

/**
 * Created by Extra on 2017/11/7.
 * GitHub cnhttt@163.com
 * Work to SZFP
 */
@Controller
public class TransactionRecordController extends BaseController {


    @Resource
    private TransactionService transactionService;


    @RequestMapping("recharge_page")
    public  String showRechargeRecord(HttpServletRequest req, ModelMap mode, Integer pageName){
        ResponsePage<RechargeBean> page = new ResponsePage<>();
        try {
            ManagerBean managerBean = (ManagerBean) req.getSession().getAttribute(SESSION_MANAGER);
            log.info("load  recharge   List"+managerBean.getUserName());
            if (!isEmpty(managerBean))
                page = transactionService.loadRechargeList(managerBean.getCompanyUUID(),pageName);
        }catch (Exception e){
            log.info(e.toString());
        }
        mode.addAttribute("page",page);
        return "cost-recharge";
    }


    @RequestMapping("recharge.lpm")
    public String showRechargeRecordByLPM(HttpServletRequest req,ModelMap model,Integer pageName ,String lpm){
        log.info(lpm);
        ResponsePage<RechargeBean> page = new ResponsePage<>();
        try {
            ManagerBean managerBean = (ManagerBean) req.getSession().getAttribute(SESSION_MANAGER);
            log.info("load  recharge   List"+managerBean.getUserName());
            if (!isEmpty(managerBean))
                page = transactionService.loadRechargeListByLPM(managerBean.getCompanyUUID(),pageName,lpm);
        }catch (Exception e){
            log.info(e.toString());
        }
        model.addAttribute("page",page);
        return "cost-recharge";
    }



    @RequestMapping("consumption")
    public String showConsumptionRecord(HttpServletRequest req, ModelMap model,Integer pageName){
        ResponsePage<ConsumptionBean> page = new ResponsePage<>();
        try {
            ManagerBean managerBean = (ManagerBean) req.getSession().getAttribute(SESSION_MANAGER);
            log.info("load  ConsumptionRecord   List"+managerBean.getUserName());
            if (!isEmpty(managerBean))
                page = transactionService.loadConsumptionList(managerBean.getCompanyUUID(),pageName);
        }catch (Exception e){
            log.info(e.toString());
        }
        model.addAttribute("page",page);
        return "cost-consumption";
    }


    @RequestMapping("recharge.p")
    @ResponseBody
    public String addRechargeRecord(String data){
        ResponseObj<RechargeBean> result = new ResponseObj<>();
        RechargeBean rechargeBean;
        try {
            log.info(data);
            rechargeBean = new GsonUtils().toBean(data,RechargeBean.class);
            if (transactionService.addRecharge(rechargeBean)){
                result.setCode(ResponseObj.OK);
                result.setMsg("add success");
            }
            else {

                result.setCode(ResponseObj.EMPUTY);
                result.setMsg("Please check if the s exists!!");
            }
        }catch (Exception e){

            result.setCode(ResponseObj.FAILED);
            result.setMsg(e.toString());
        }
        return new GsonUtils().toJson(result);

    }
    @RequestMapping("rechargeList.p")
    @ResponseBody
    public String addRechargeRecordList(String data){
        ResponseObj<RechargeBean> result = new ResponseObj<>();
        ArrayList<RechargeBean> rechargeBean;
        try {
            log.info(data);
            rechargeBean = new GsonUtils().fromJson(data,new TypeToken<ArrayList<RechargeBean>>(){}.getType());
            if (transactionService.addRechargeList(rechargeBean)){
                result.setCode(ResponseObj.OK);
                result.setMsg("add success");
            }
            else {

                result.setCode(ResponseObj.EMPUTY);
                result.setMsg("Please check if the s exists!!");
            }
        }catch (Exception e){

            result.setCode(ResponseObj.FAILED);
            result.setMsg(e.toString());
        }
        return new GsonUtils().toJson(result);

    }




    @RequestMapping("consumption.p")
    @ResponseBody
    public String addConsumptionRecord(String data){
        ResponseObj<ConsumptionBean> result = new ResponseObj<>();
        ConsumptionBean consumptionBean;
        try {
            log.info(data);
            consumptionBean = new GsonUtils().toBean(data,ConsumptionBean.class);
            if (transactionService.addConsumption(consumptionBean)){
                result.setCode(ResponseObj.OK);
                result.setMsg("add success");
            }
            else {

                result.setCode(ResponseObj.EMPUTY);
                result.setMsg("Please check if the s exists!!");
            }
        }catch (Exception e){

            result.setCode(ResponseObj.FAILED);
            result.setMsg(e.toString());
        }
        return new GsonUtils().toJson(result);

    }


    @RequestMapping("consumptionList.p")
    @ResponseBody
    public String addConsumptionRecordList(String data){
        ResponseObj<ConsumptionBean> result = new ResponseObj<>();
        ArrayList<ConsumptionBean> consumptionBean;
        try {
            log.info(data);
            consumptionBean = new GsonUtils().fromJson(data,new TypeToken<ArrayList<ConsumptionBean>>(){}.getType());
            if (transactionService.addConsumptionList(consumptionBean)){
                result.setCode(ResponseObj.OK);
                result.setMsg("add success");
            }
            else {

                result.setCode(ResponseObj.EMPUTY);
                result.setMsg("Please check if the s exists!!");
            }
        }catch (Exception e){

            result.setCode(ResponseObj.FAILED);
            result.setMsg(e.toString());
        }
        return new GsonUtils().toJson(result);

    }



}
