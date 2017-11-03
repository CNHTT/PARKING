package com.extra.controller;

import com.extra.model.ManagerBean;
import com.extra.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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


    @RequestMapping("admin_list")
    public  String  adminList(HttpServletRequest req, ModelMap model,Integer pageName){
        ManagerBean managerBean = (ManagerBean) req.getSession().getAttribute(SESSION_MANAGER);
        model.addAttribute("adminList",adminService.loadParkingLotList(managerBean.getCompanyUUID(),pageName,10));
        return "admin-list";
    }



    @RequestMapping("add/admin")
    public  String addAdmin(HttpServletRequest req,ModelMap model){
        ManagerBean managerBean = (ManagerBean) req.getSession().getAttribute(SESSION_MANAGER);


        return "admin-add";
    }





    @RequestMapping("admin_permission")
    public  String  adminPermission(){return "admin-permission";}

    @RequestMapping("admin_role")
    public  String  adminRole(){return "admin-role";}


    @RequestMapping("admin/name")
    public  String adminFromName(String name){

        return "admin-list";
    }

}
