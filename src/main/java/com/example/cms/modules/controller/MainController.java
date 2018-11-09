package com.example.cms.modules.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName MainController
 * @Description : TODO
 * @Author losh
 * @Date 2018-09-28 15:47
 * @Version 1.0
 */
@Controller
public class MainController {

    private static Logger logger = LoggerFactory.getLogger(MainController.class);

       @RequestMapping(value ="/index")
       public String indexPage() {
           return "static/index";
       }


    @RequestMapping(value = "/login")
    public String loginPage() {
        return "static/loginPage";
    }

    @RequestMapping(value = "/success")
    public String successPage() {
        return "static/success";
    }
}

