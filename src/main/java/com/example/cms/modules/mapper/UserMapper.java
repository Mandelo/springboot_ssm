package com.example.cms.modules.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.cms.modules.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * Created by losho on 2018-09-15.
 */
@Mapper
@Component
public interface UserMapper extends BaseMapper<User>{

    User selectByUsername(String username);
}
