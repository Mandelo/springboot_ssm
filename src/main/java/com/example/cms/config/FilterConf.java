package com.example.cms.config;

import com.example.cms.filter.HeaderFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName FilterConf
 * @Description : TODO
 * @Author losh
 * @Date 2018-10-31 23:27
 * @Version 1.0
 */
@Configuration
public class FilterConf {
    @Bean
    public FilterRegistrationBean someFilterRegistration1() {
        System.out.println("-----------------------------跨域过滤器---------------------------------");
        //新建过滤器注册类
        FilterRegistrationBean registration = new FilterRegistrationBean();
        // 添加写好的过滤器
        registration.setFilter(new HeaderFilter());
        // 设置过滤器的URL模式
        registration.addUrlPatterns("/*");
        return registration;
    }

}

