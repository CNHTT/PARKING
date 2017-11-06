package com.extra.controller;

import com.extra.dao.ParkingDao;
import com.extra.model.ManagerBean;
import com.extra.service.AdminService;
import com.extra.service.ParkingService;
import com.extra.utils.MD5Util;
import com.extra.utils.NetworkUtil;
import com.extra.utils.TimeUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.sql.Time;

import static com.extra.utils.SessionUtils.SESSION_MANAGER;

/**
 * Created by Extra on 2017/10/30.
 * GitHub cnhttt@163.com
 * Work to SZFP
 */
@Controller
public class AdminController extends BaseController {

    @Resource
    private AdminService adminService;

    @Resource
    private ParkingService parkingService;


    @RequestMapping("admin_list")
    public  String  adminList(HttpServletRequest req, ModelMap model,Integer pageName){
        ManagerBean managerBean = (ManagerBean) req.getSession().getAttribute(SESSION_MANAGER);
        model.addAttribute("adminList",adminService.loadParkingLotList(managerBean.getCompanyUUID(),pageName,10));
        return "admin-list";
    }



    @RequestMapping("add/admin")
    public  String addAdmin(HttpServletRequest req,ModelMap model){
        ManagerBean managerBean = (ManagerBean) req.getSession().getAttribute(SESSION_MANAGER);
        model.addAttribute("parkingLotList",parkingService.loadParkingLotList(managerBean.getCompanyUUID()));
        return "admin-add";
    }


    @RequestMapping("addAdmin")
    @ResponseBody
    private String postAddAdmin(HttpServletRequest req,ManagerBean managerBean){
        try {

            ManagerBean manager = (ManagerBean) req.getSession().getAttribute(SESSION_MANAGER);
            log.info(managerBean.toString());
            log.info(NetworkUtil.getIpAddress(req));
            String number  = TimeUtils.getUniqueNumber(adminService.getTotalNumber(manager.getCompanyUUID()));
            managerBean.setNumber(number);
            managerBean.setUUID(TimeUtils.getUUID());
            if (managerBean.getParkingUuid().equals("0"))
                managerBean.setType(1); else managerBean.setType(0);
            managerBean.setUserPwd(MD5Util.string2MD5(managerBean.getUserPwd()));
            managerBean.setCompanyUUID(manager.getCompanyUUID());
            adminService.addManagerInfo(managerBean);
            return  "Yes";
        }catch (Exception e){
            log.info("ADD MANAGER: "+e.toString());
            return "No";
        }

    }



    @RequestMapping("admin_permission")
    public  String  adminPermission(){return "admin-permission";}

    @RequestMapping("admin_role")
    public  String  adminRole(){return "admin-role";}


    @RequestMapping("admin/name")
    public  String adminFromName(String name,HttpServletRequest req,ModelMap model,Integer pageName){
        ManagerBean managerBean = (ManagerBean) req.getSession().getAttribute(SESSION_MANAGER);
        model.addAttribute("adminList",adminService.loadParkingLotListFromName(managerBean.getCompanyUUID(),pageName,10,name));
        return "admin-list";
    }

}
