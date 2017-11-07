package com.extra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Extra on 2017/11/7.
 * GitHub cnhttt@163.com
 * Work to SZFP
 */
@Controller
public class TransactionRecordController extends BaseController {

    @RequestMapping("recharge_page")
    public  String showRechargeRecord(HttpServletRequest req, ModelMap mode, Integer pageName){
        return "cost-recharge";
    }

}
