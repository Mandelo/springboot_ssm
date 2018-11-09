
package com.example.cms.config;


import com.example.cms.Intereceptor.SessionInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName WebMvcConfig
 * @Description : TODO
 * @Author losh
 * @Date 2018-11-09 21:35
 * @Version 1.0
 *
 */

@Configuration
public class WebMvcConf implements WebMvcConfigurer {
    @Bean
    SessionInterceptor sessionInterceptor() {
        return new SessionInterceptor();
    }

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(sessionInterceptor())
                .addPathPatterns("/**").excludePathPatterns("/doLogin");
 }
 }


