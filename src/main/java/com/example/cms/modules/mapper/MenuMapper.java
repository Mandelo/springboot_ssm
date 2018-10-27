package com.example.cms.modules.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName MenuMapper
 * @Description : TODO
 * @Author losh
 * @Date 2018-10-24 15:03
 * @Version 1.0
 */
@Mapper
@Component
public interface MenuMapper {
    /**
    *  @Description: 通过id获取角色url
    *  @Param [roleId]
    *  @Return java.util.List<java.lang.String>
    */
    List<String> getResUrlsByRoleId(Integer roleId);
}
