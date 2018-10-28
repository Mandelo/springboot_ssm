package com.example.cms.modules.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.cms.modules.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;


/**
 * @ClassName RoleMapper
 * @Description : TODO
 * @Author losh
 * @Date 2018-10-28 21:23
 * @Version 1.0
 */
@Component
@Mapper
public interface RoleMapper extends BaseMapper<Role> {

}
