package com.example.demo.service.impl;

import com.example.demo.entity.Goods;
import com.example.demo.mapper.GoodsMapper;
import com.example.demo.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by losho on 2018-09-15.
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    GoodsMapper goodsMapper;

    @Override
    public Goods selectById(Integer id) {
       Goods goods =  goodsMapper.selectById(id);
        return goods;
    }
}
