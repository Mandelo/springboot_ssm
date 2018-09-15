package com.example.demo.mapper;

import com.example.demo.entity.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * Created by losho on 2018-09-15.
 */
@Mapper
@Repository
public interface GoodsMapper {

    Goods selectById(Integer id);

}
