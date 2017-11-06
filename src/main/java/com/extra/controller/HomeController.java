package com.extra.controller;

import com.extra.model.CompanyInformationBean;
import com.extra.model.HomeBean;
import com.extra.model.ManagerBean;
import com.extra.model.StatisticsBean;
import com.extra.service.HomeService;
import com.extra.utils.NetworkUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.extra.utils.SessionUtils.SESSION_MANAGER;

/**
 * Created by Extra on 2017/10/30.
 * GitHub cnhttt@163.com
 * Work to SZFP
 */
@Controller
public class HomeController extends BaseController {
    private List<StatisticsBean>  statisticsList ;
    private CompanyInformationBean company;

    @Resource
    private HomeService homeService;

    @RequestMapping("welcome")
    private  String welcome(HttpServletRequest req, ModelMap modelMap){
        HomeBean homeBean = new HomeBean();
        ManagerBean managerBean = (ManagerBean) req.getSession().getAttribute(SESSION_MANAGER);
        homeBean.setIp(NetworkUtil.getIpAddress(req));
        homeBean.setLoginNum(100);
        homeBean.setTime(new Date());
        statisticsList = new ArrayList<>();
        StatisticsBean  statisticsBean = new StatisticsBean();
        statisticsList = new ArrayList<>();
        //
        for (int i = 0; i <5 ; i++) {
            statisticsList.add(statisticsBean);
        }
        //
        homeBean.setList(statisticsList);
        req.setAttribute("data",homeBean);
        modelMap.addAttribute("company",homeService.getCompanyInformationByUUID(managerBean.getCompanyUUID()));
        return "welcome";
    }

}
