package com.extra.controller;

import com.extra.model.ManagerBean;
import com.extra.model.MemberBean;
import com.extra.model.RechargeBean;
import com.extra.model.response.ResponsePage;
import com.extra.service.TransactionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import static com.extra.utils.DataUtils.isEmpty;
import static com.extra.utils.SessionUtils.SESSION_MANAGER;

/**
 * Created by Extra on 2017/11/7.
 * GitHub cnhttt@163.com
 * Work to SZFP
 */
@Controller
public class TransactionRecordController extends BaseController {


    @Resource
    private TransactionService transactionService;


    @RequestMapping("recharge_page")
    public  String showRechargeRecord(HttpServletRequest req, ModelMap mode, Integer pageName){
        ResponsePage<RechargeBean> page = new ResponsePage<>();
        try {
            ManagerBean managerBean = (ManagerBean) req.getSession().getAttribute(SESSION_MANAGER);
            log.info("load  recharge   List"+managerBean.getUserName());
            if (!isEmpty(managerBean))
                page = transactionService.loadRechargeList(managerBean.getCompanyUUID(),pageName);
        }catch (Exception e){
            log.info(e.toString());
        }
        mode.addAttribute("page",page);
        return "cost-recharge";
    }

}
