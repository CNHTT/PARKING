package com.extra.controller;

import com.extra.model.MemberBean;
import com.extra.model.response.ResponsePage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Extra on 2017/10/30.
 * GitHub cnhttt@163.com
 * Work to SZFP
 */
@Controller
public class MemberController extends  BaseController {

  @RequestMapping("member_list")
  public String memberList(HttpServletRequest req, ModelMap map){
    ResponsePage<MemberBean> page = new ResponsePage<>();



    map.addAttribute("page",page);
    return "member-list";
  }


    @RequestMapping("member_del")
    public String memberDel(){return "member-del";}

    @RequestMapping("member/LPM")
    public String  memberFromLicensePlateNumber(){
      return "redirect:member-list";
    }
}
