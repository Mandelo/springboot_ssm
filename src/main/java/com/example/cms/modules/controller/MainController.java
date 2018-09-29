package com.example.cms.modules.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

       @RequestMapping(value ="index")
       public String indexPage() {
           return "static/index";
       }

    @RequestMapping(value = "login")
    public String loginPage() {
        return "static/login";
    }

}

