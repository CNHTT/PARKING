package com.extra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Extra on 2017/10/30.
 * GitHub cnhttt@163.com
 * Work to SZFP
 */
@Controller
public class DataController extends   BaseController {

    @RequestMapping("data_list")
    public String  dataList(){return "data-list";}
}
