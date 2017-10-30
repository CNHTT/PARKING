package com.extra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by Extra on 2017/10/30.
 * GitHub cnhttt@163.com
 * Work to SZFP
 */
@Controller
public class AdminController extends BaseController {

    @RequestMapping("admin_list")
    public  String  adminList(){return "admin-list";}
    @RequestMapping("admin_permission")
    public  String  adminPermission(){return "admin-permission";}
    @RequestMapping("admin_role")
    public  String  adminRole(){return "admin-role";}

}
