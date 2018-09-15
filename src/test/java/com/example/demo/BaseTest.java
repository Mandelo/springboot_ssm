package com.example.demo;

import com.example.demo.entity.Goods;
import com.example.demo.service.GoodsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by losho on 2018-09-15.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseTest{

    @Autowired
    GoodsService goodsService;

    @Test
    public void selectById(){
        System.out.println(goodsService.selectById(1));
    }

}
