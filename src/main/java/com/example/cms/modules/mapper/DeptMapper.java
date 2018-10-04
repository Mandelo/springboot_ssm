package com.example.cms.modules.mapper;

import com.example.cms.modules.entity.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @ClassName DeptMapper
 * @Description : TODO
 * @Author losh
 * @Date 2018-10-04 22:21
 * @Version 1.0
 */
@Mapper
@Component
public interface DeptMapper {

    Dept selectById(Integer id);

}
