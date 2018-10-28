package com.example.cms.realm;

import com.example.cms.factory.IShiro;
import com.example.cms.factory.ShiroFactory;
import com.example.cms.modules.entity.ShiroUser;
import com.example.cms.modules.entity.User;
import com.example.cms.modules.mapper.UserMapper;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName MyShiroRealm
 * @Description : TODO
 * @Author losh
 * @Date 2018-09-28 16:21
 * @Version 1.0
 */
public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserMapper userMapper;

    /**
     * @Description: 授权
     * @Param [principalCollection]
     * @Return org.apache.shiro.authz.AuthorizationInfo
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        IShiro shiroFactory = ShiroFactory.me();
        String account = (String) principals.getPrimaryPrincipal();
        User user = userMapper.selectByAccount(account);
        ShiroUser shiroUser = shiroFactory.convToShiroUser(user);
        List<Integer> roleList = shiroUser.getRoleList();
        Set<String> permissionSet = new HashSet<>();
        Set<String> roleNameSet = new HashSet<>();

        for (Integer roleId : roleList) {
            List<String> permissions = shiroFactory.findPermissionsByRoleId(roleId);
            if (permissions != null) {
                for (String permission : permissions) {
                    permissionSet.add(permission);
                    System.out.println("\n" + "permission:" + permission);
                }
            }
            String roleName = shiroFactory.findRoleNameByRoleId(roleId);
            roleNameSet.add(roleName);
            System.out.println("\n"+"roleName:"+roleName);
        }

        info.addStringPermissions(permissionSet);
        info.addRoles(roleNameSet);
        return info;
    }

    /**
     * @Description: 登录
     * @Param [authenticationToken]
     * @Return org.apache.shiro.authc.AuthenticationInfo
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        if (authenticationToken.getPrincipal() == null) {
            return null;
        }
        //获取用户信息
        String account = authenticationToken.getPrincipal().toString();
        User user = userMapper.selectByAccount(account);
        if (null == user) {
            return null;
        } else {
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(account, user.getPassword().toString(), getName());
            return simpleAuthenticationInfo;
        }
    }


}

