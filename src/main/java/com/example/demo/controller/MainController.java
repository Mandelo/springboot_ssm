package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by losho on 2018-09-15.
 */
@Controller
@RequestMapping("/home")
public class MainController {


    private static Logger logger = LoggerFactory.getLogger(MainController.class);

    /**
     * 测试beetl模板
     *
     * @return
     */
    @RequestMapping("/add")
    public ModelAndView home() {

        ModelAndView modelAndView = new ModelAndView();
        logger.info("add request");
        modelAndView.addObject("email", "apk2sf@163.com");
        modelAndView.setViewName("add");
        return modelAndView;
    }

}
