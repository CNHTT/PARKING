package com.extra.controller;

import com.extra.dao.ParkingDao;
import com.extra.model.*;
import com.extra.model.response.ResponseObj;
import com.extra.service.HomeService;
import com.extra.service.ParkingService;
import com.extra.utils.DataUtils;
import com.extra.utils.GsonUtils;
import com.extra.utils.NetworkUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.extra.utils.DataUtils.isEmpty;
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

    @Resource
    private ParkingService parkingService;

    @RequestMapping("welcome")
    private  String welcome(HttpServletRequest req, ModelMap modelMap){
        ManagerBean managerBean = (ManagerBean) req.getSession().getAttribute(SESSION_MANAGER);
        HomeBean homeBean = new HomeBean();
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


    @RequestMapping("companyInfo.p")
    @ResponseBody
    private String loadCompanyAndLotByDevice(HttpServletRequest request, String companyUUID,String uuid, String parkingUuid,String sn){
        ResponseObj<CompanyInformationBean> result = new ResponseObj<>();
        try {
            log.info(NetworkUtil.getIpAddress(request) + "-" + companyUUID + "-" +uuid +"-" +parkingUuid);
            if (isEmpty(sn)){
                result.setCode(ResponseObj.EMPUTY);
                result.setMsg("Please check if the device exists!!");
            }
            else
            {
                DeviceBean deviceBean = homeService.loadDeviceBySn(sn,companyUUID);
                if (isEmpty(deviceBean)){
                    result.setCode(ResponseObj.EMPUTY);
                    result.setMsg("Please check if the device exists!!");
                }else {
                    ArrayList<ParkingLotBean> list = new ArrayList<>();
                    CompanyInformationBean companyLotBean =   homeService.getCompanyInformationByUUID(companyUUID);
                    ParkingLotBean parkingLotBean  =homeService.loadParkingBy(parkingUuid);
                    companyLotBean.setDevice(deviceBean);
                    if (isEmpty(parkingUuid)){
                        companyLotBean.setLotList(parkingService.loadParkingLotList(companyUUID));
                    }else if (isEmpty(parkingLotBean)){
                        companyLotBean.setLotList(parkingService.loadParkingLotList(companyUUID));
                    }else {
                        list.add(parkingLotBean);
                        companyLotBean.setLotList(list);
                    }
                    result.setData(companyLotBean);
                    result.setCode(ResponseObj.OK);
                }
            }

        }catch (Exception e){
            result.setCode(ResponseObj.FAILED);
            result.setMsg(e.toString());
        }
        return new GsonUtils().toJson(result);
    }

}
