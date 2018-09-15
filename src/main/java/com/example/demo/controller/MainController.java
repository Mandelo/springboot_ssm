package com.example.demo.controller;

import com.example.demo.entity.Goods;
import com.example.demo.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by losho on 2018-09-15.
 */
@RestController
public class MainController {

    @Autowired
    GoodsService goodsService;

    @RequestMapping(value = "/getAGoodsInfo")
    public Goods selectById(@RequestParam Integer id){
        return  goodsService.selectById(id);
    }

}
