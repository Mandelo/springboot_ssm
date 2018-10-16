package com.example.cms.factory;

import com.example.cms.Util.SpringContextHolder;
import com.example.cms.modules.entity.User;
import com.example.cms.modules.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

/**
 * @ClassName ConstantFactory
 * @Description : TODO
 * @Author losh
 * @Date 2018-10-15 21:50
 * @Version 1.0
 */
@Component
@DependsOn("springContextHolder")
public class ConstantFactory implements IConstantFactory {

    @Autowired
    UserMapper userMapper;
    @Override
    public String getSingleRoleName(Integer roleId) {
        return null;
    }

    @Override
    public String getSaltByAccount(String account) {
        User user = userMapper.selectByAccount(account);
        return user.getSalt();
    }

    public static IConstantFactory me() {
        return SpringContextHolder.getBean("constantFactory");
    }
}

