package com.example.demo.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * Created by losho on 2018-09-15.
 */
@Mapper
@Component
public interface UserMapper extends BaseMapper<User>{

}
