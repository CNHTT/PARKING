package com.extra.controller;

import com.extra.model.ManagerBean;
import com.extra.service.LoginService;
import com.extra.utils.MD5Util;
import com.extra.utils.SessionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static com.extra.utils.DataUtils.isEmpty;
import static com.extra.utils.DataUtils.isNullString;
import static com.extra.utils.RegexUtils.isCheckPassWord;
import static com.extra.utils.SessionUtils.SESSION_MANAGER;

/**
 * Created by Extra on 2017/10/27.
 * GitHub cnhttt@163.com
 * Work to SZFP
 */
@Controller
public class LoginController extends BaseController {


    @Resource
    private LoginService loginService;

    @RequestMapping("/login")
    private  String login(){
        return "login";
    }

    @RequestMapping("/index")
    private  String index(HttpServletRequest request){
        if (request.getSession().getAttribute("SESSION_MANAGER")==null)return "login";
        return "index";
    }

    @RequestMapping("/signout")
    private  String signOut(HttpSession session){
        session.setAttribute(SESSION_MANAGER,null);
        return "redirect:login";
    }


    @RequestMapping("/signin")
    private String signIn(String username, String password,HttpServletRequest req,HttpSession session){
        ManagerBean managerBean = null;
        if (!isNullString(username)&&isCheckPassWord(password)) managerBean =loginService.getManagerInfo(username, MD5Util.string2MD5(password));
        else
        {
            req.setAttribute("error","Please input UserNameOrEmail  PassWord!");
            return "forward:login";
        }

        if (isEmpty(managerBean)){
            req.setAttribute("error","The user does not exist! Please check the");
            return "forward:login";
        }else {
            session.setAttribute(SESSION_MANAGER,managerBean);
            return "redirect:index";
        }
    }
}
