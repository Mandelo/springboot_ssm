package com.example.demo.service;


import com.example.demo.entity.Goods;

/**
 * Created by losho on 2018-09-15.
 */
public interface GoodsService {

    Goods selectById(Integer id);
}
