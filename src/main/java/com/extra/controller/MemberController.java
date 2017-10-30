package com.extra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Extra on 2017/10/30.
 * GitHub cnhttt@163.com
 * Work to SZFP
 */
@Controller
public class MemberController extends  BaseController {

  @RequestMapping("member_list")
    public String memberList(){return "member-list";}


    @RequestMapping("member_del")
    public String memberDel(){return "member-del";}
}
