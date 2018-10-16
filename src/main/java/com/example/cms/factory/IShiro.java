package com.example.cms.factory;

import com.example.cms.modules.entity.ShiroUser;
import com.example.cms.modules.entity.User;
import org.apache.shiro.authc.SimpleAuthenticationInfo;

import java.util.List;

/**
 * @ClassName IShiro
 * @Description : 定义shirorealm所需数据的接口
 * @Author losh
 * @Date 2018-10-03 15:22
 * @Version 1.0
 */
public interface IShiro {

    /**
    *  @Description: 根据账号获取登录用户
    *  @Param [account]
    *  @Return com.example.cms.modules.entity.User
    */
    User user(String account);

    /**
    *  @Description: 根据系统用户获取shiro用户
    *  @Param [user]
    *  @Return com.example.cms.modules.entity.ShiroUser
    */
    ShiroUser shiroUser(User user);

    /**
    *  @Description: 通过角色Id获取权限列表
    *  @Param [roleId]
    *  @Return java.util.List<java.lang.String>
    */
    List<String> findPermissionsByRoleId(Integer roleId);

    /**
    *  @Description: 根据角色id获取角色名称
    *  @Param [roleId]
    *  @Return java.lang.String
    */
    String findRoleNameByRoleId(Integer roleId);

    /**
    *  @Description: 获取shiro的认证信息
    *  @Param [shiroUser, user, realmName]
    *  @Return org.apache.shiro.authc.SimpleAuthenticationInfo
    */
    SimpleAuthenticationInfo info(ShiroUser shiroUser, User user, String realmName);
}
