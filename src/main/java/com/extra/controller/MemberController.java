package com.extra.controller;

import com.extra.model.CompanyInformationBean;
import com.extra.model.ManagerBean;
import com.extra.model.MemberBean;
import com.extra.model.response.ResponseObj;
import com.extra.model.response.ResponsePage;
import com.extra.service.MemberService;
import com.extra.utils.GsonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import static com.extra.utils.DataUtils.isEmpty;
import static com.extra.utils.DataUtils.isNullString;
import static com.extra.utils.SessionUtils.SESSION_MANAGER;

/**
 * Created by Extra on 2017/10/30.
 * GitHub cnhttt@163.com
 * Work to SZFP
 */
@Controller
public class MemberController extends  BaseController {

  @Resource
  private MemberService memberService;


  @RequestMapping("member_list")
  public String memberList(HttpServletRequest req, ModelMap map,Integer pageName){
    ResponsePage<MemberBean> page = new ResponsePage<>();
    try {
      ManagerBean managerBean = (ManagerBean) req.getSession().getAttribute(SESSION_MANAGER);
      log.info("loadMemberList"+managerBean.getUserName());
      if (!isEmpty(managerBean))
      page = memberService.loadMemberList(managerBean.getCompanyUUID(),pageName);
    }catch (Exception e){
      log.debug(e.toString());
    }
    map.addAttribute("page",page);
    return "member-list";
  }

  @RequestMapping("member_del")
  public String memberDelList(HttpServletRequest req, ModelMap map,Integer pageName){
    ResponsePage<MemberBean> page = new ResponsePage<>();
    try {
      ManagerBean managerBean = (ManagerBean) req.getSession().getAttribute(SESSION_MANAGER);
      log.info("memberDelList"+managerBean.getUserName());
      if (!isEmpty(managerBean))
        page = memberService.loadMemberDelList(managerBean.getCompanyUUID(),pageName);
    }catch (Exception e){
      log.info(e.toString());
    }
    map.addAttribute("page",page);
    return "member-del";
  }



    @RequestMapping("member_LPM")
    public String  memberFromLicensePlateNumber(String lpm,HttpServletRequest req, ModelMap map)
    {
      if (isNullString(lpm)) return "member-list";
      ResponsePage<MemberBean> page = new ResponsePage<>();
      try {
        ManagerBean managerBean = (ManagerBean) req.getSession().getAttribute(SESSION_MANAGER);
        log.info("loadMemberList"+managerBean.getUserName());
        if (!isEmpty(managerBean))
          page = memberService.loadMemberFromLPM(managerBean.getCompanyUUID(),lpm);
      }catch (Exception e){
        log.debug(e.toString());
      }
      map.addAttribute("page",page);
      return "member-list";
    }



    @RequestMapping("member_del_LPM")
    public String  memberDelFromLicensePlateNumber(String lpm,HttpServletRequest req, ModelMap map)
    {
      if (isNullString(lpm)) return "member-list";
      ResponsePage<MemberBean> page = new ResponsePage<>();
      try {
        ManagerBean managerBean = (ManagerBean) req.getSession().getAttribute(SESSION_MANAGER);
        log.info("loadMemberList"+managerBean.getUserName());
        if (!isEmpty(managerBean))
          page = memberService.loadMemberDelFromLPM(managerBean.getCompanyUUID(),lpm);
      }catch (Exception e){
        log.info(e.toString());
      }
      map.addAttribute("page",page);
      return "member-del";
    }






    @RequestMapping("member/uuid")
    public  String  loadMemberFromUUID(String uuid,ModelMap modelMap){
      log.debug(uuid);
      modelMap.addAttribute("member" ,memberService.loadMemberFromUUID(uuid));
      return "member-show";
    }

    @RequestMapping(value = "checkMemBer.p")
    @ResponseBody
    private String loadCheckMemberByUUID(String uuid){
      ResponseObj<MemberBean> result = new ResponseObj<>();
      MemberBean memberBean;
      try{
        memberBean = memberService.loadMemberFromCardId(uuid);
        if (isEmpty(memberBean)){
          result.setCode(ResponseObj.EMPUTY);
          result.setMsg("Please check if the device exists!!");
        }else {
          result.setCode(ResponseObj.OK);
          result.setData(memberBean);
        }


      }catch (Exception e){
        result.setCode(ResponseObj.FAILED);
        result.setMsg(e.toString());
      }
      return new GsonUtils().toJson(result);
    }

    @RequestMapping(value = "addMember.p")
    @ResponseBody
    private String loadAddMember(String data){
      ResponseObj<CompanyInformationBean> result = new ResponseObj<>();
      MemberBean memberBean;

      try{
        log.info(data);
        memberBean = new GsonUtils().toBean(data,MemberBean.class);
        memberService.updateMember(memberBean.getCardId());
          if (memberService.addMember(memberBean)){

            result.setCode(ResponseObj.OK);
            result.setData(memberBean);
          }
          else {

            result.setCode(ResponseObj.EMPUTY);
            result.setMsg("Please check if the s exists!!");
          }


      }catch (Exception e){
        result.setCode(ResponseObj.FAILED);
        result.setMsg(e.toString());
      }
      return new GsonUtils().toJson(result);
    }


}
