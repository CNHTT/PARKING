package com.extra.controller;

import com.extra.model.DeviceBean;
import com.extra.model.ManagerBean;
import com.extra.model.response.ResponsePage;
import com.extra.service.HomeService;
import org.springframework.stereotype.Controller;
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
}
