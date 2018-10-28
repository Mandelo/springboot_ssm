package com.example.cms.factory;

import com.example.cms.Util.SpringContextHolder;
import com.example.cms.modules.entity.Role;
import com.example.cms.modules.entity.User;
import com.example.cms.modules.mapper.RoleMapper;
import com.example.cms.modules.mapper.UserMapper;
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

    private RoleMapper roleMapper = SpringContextHolder.getBean(RoleMapper.class);

    private UserMapper userMapper = SpringContextHolder.getBean(UserMapper.class);

    @Override
    public String getSingleRoleName(Integer roleId) {
        if (0 == roleId) {
            return "--";
        }
        Role role = roleMapper.selectById(roleId);
        return role.getName();
    }

    @Override
    public String getSaltByAccount(String account) {
        User user = userMapper.selectByAccount(account);
        return user.getSalt();
    }

    /**
     * @Description: 通过角色id获取角色英文名称
     * @Param [roleId]
     * @Return java.lang.String
     */
    @Override
    public String getSingleRoleTip(Integer roleId) {
        if (0 == roleId) {
            return "--";
        }
        Role role = roleMapper.selectById(roleId);
        return role.getTips();
    }

    public static IConstantFactory me() {
        return SpringContextHolder.getBean("constantFactory");
    }
}

