package com.example.cms;

import org.mybatis.spring.annotation.MapperScan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.cms.modules.mapper")
public class SpringbootSsmApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringbootSsmApplication.class, args);
    }

}
