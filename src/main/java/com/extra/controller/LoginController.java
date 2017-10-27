package com.extra.controller;

import com.extra.model.ManagerBean;
import com.extra.utils.SessionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Extra on 2017/10/27.
 * GitHub cnhttt@163.com
 * Work to SZFP
 */
@Controller
public class LoginController extends BaseController {


    @RequestMapping("/login")
    private  String login(){
        return "login";
    }


    @RequestMapping("/signout")
    private  String signOut(HttpSession session){
        session.setAttribute("id",null);
        session.setAttribute(SessionUtils.SESSION_ADMIN_USER,null);
        return "redirect:login";
    }


    @RequestMapping("/signin")
    private String signIn(String username, String password,HttpServletRequest req,HttpSession session){
        ManagerBean managerBean = null;


        return "";
    }
}
