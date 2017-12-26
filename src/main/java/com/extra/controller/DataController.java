package com.extra.controller;

import com.extra.model.DeviceBean;
import com.extra.model.ManagerBean;
import com.extra.model.response.ResponsePage;
import com.extra.service.HomeService;
import com.extra.utils.NetworkUtil;
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
public class DataController extends   BaseController {

    @Resource
    private HomeService homeService;

    @RequestMapping("data_list")
    public String  dataList(HttpServletRequest req, ModelMap model,Integer pageName){
        ResponsePage<DeviceBean> page = new ResponsePage<>();
        try {

            ManagerBean managerBean = (ManagerBean) req.getSession().getAttribute(SESSION_MANAGER);
            page  =homeService.loadAllDevice(managerBean.getCompanyUUID(),pageName);
        }catch (Exception e){
            log.info("data_list:"+e.toString());

        }
        model.addAttribute("page",page);
        return "data-list";
    }
    @RequestMapping("add_device")
    public String  addDevice(HttpServletRequest req, ModelMap model,Integer pageName){

        return "device-add";
    }

    @RequestMapping("addDevice")
    @ResponseBody
    public String  addDevice(String sn,HttpServletRequest req){

        try {
            ManagerBean manager = (ManagerBean) req.getSession().getAttribute(SESSION_MANAGER);
            log.info(manager.toString());
            log.info(NetworkUtil.getIpAddress(req));
            String number  = TimeUtils.getUniqueNumber(homeService.getTotalNumber(manager.getCompanyUUID()));
            DeviceBean deviceBean = new DeviceBean();
            deviceBean.setSn(sn);
            deviceBean.setCompany(manager.getCompanyUUID());
            deviceBean.setUuid(TimeUtils.getUUID());
            deviceBean.setNumber(number);
            homeService.addDevice(deviceBean);
            return  "Yes";
        }catch (Exception e){
            log.info(e.toString());
            return "NO";
        }
    }
}
