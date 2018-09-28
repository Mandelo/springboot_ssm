package com.example.cms.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName DefaultViewConf
 * @Description : 设置主页
 * @Author losh
 * @Date 2018-09-28 15:59
 * @Version 1.0
 */
@Configuration
public class DefaultViewConf extends WebMvcConfigurationSupport {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("static/index");
    }

}

