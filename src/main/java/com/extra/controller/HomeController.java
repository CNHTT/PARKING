package com.extra.controller;

import com.extra.model.HomeBean;
import com.extra.utils.NetworkUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * Created by Extra on 2017/10/30.
 * GitHub cnhttt@163.com
 * Work to SZFP
 */
@Controller
public class HomeController extends BaseController {

    @RequestMapping("welcome")
    private  String welcome(HttpServletRequest req, HttpServletResponse response){
        HomeBean homeBean = new HomeBean();
        try {
            homeBean.setIp(NetworkUtil.getIpAddress(req));
        } catch (IOException e) {
            homeBean.setIp("999.999.99.99");
        }
        homeBean.setLoginNum(100);
        homeBean.setTime(new Date());
        req.setAttribute("data",homeBean);
        return "welcome";
    }

}
