package com.example.cms.factory;

import com.example.cms.Util.Convert;
import com.example.cms.Util.SpringContextHolder;
import com.example.cms.modules.entity.Dept;
import com.example.cms.modules.entity.ShiroUser;
import com.example.cms.modules.entity.User;
import com.example.cms.modules.mapper.DeptMapper;
import com.example.cms.modules.mapper.MenuMapper;
import com.example.cms.modules.mapper.UserMapper;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ShiroFactory
 * @Description : shiro工厂
 * @Author losh
 * @Date 2018-10-04 21:50
 * @Version 1.0
 */
@Service
@DependsOn("springContextHolder")
@Transactional(readOnly = true)
public class ShiroFactory implements IShiro {

    private UserMapper userMapper = SpringContextHolder.getBean(UserMapper.class);

    private DeptMapper deptMapper = SpringContextHolder.getBean(DeptMapper.class);

    private MenuMapper menuMapper  = SpringContextHolder.getBean(MenuMapper.class);

    public static IShiro me() {
        return SpringContextHolder.getBean(IShiro.class);
    }

    //TODO 错误处理
    @Override
    public User user(String account) {
        User user = userMapper.selectByAccount(account);
        if (null == user) {
            System.out.println("ERROR");
        }
        if (user.getStatus() == 2) {
            System.out.println("ERROR");
        }
        return user;
    }

    //TODO
    @Override
    public ShiroUser convToShiroUser(User user) {
        ShiroUser shiroUser = new ShiroUser();
        shiroUser.setId(user.getId());
        Dept dept = deptMapper.selectById(user.getId());
        shiroUser.setAccount(user.getAccount());
        shiroUser.setDeptId(user.getDeptId());
        shiroUser.setDeptName(dept.getFullname());
        shiroUser.setName(user.getName());
        Integer[] roleArray = Convert.toIntRoleArray(user.getRoleId());
        List<Integer> roleList = new ArrayList<Integer>();
        List<String> roleNameList = new ArrayList<String>();
        for (int roleId : roleArray) {
            roleList.add(roleId);
            roleNameList.add(ConstantFactory.me().getSingleRoleName(roleId));
        }
        shiroUser.setRoleList(roleList);
        shiroUser.setRoleNames(roleNameList);
        return shiroUser;
    }

    @Override
    public List<String> findPermissionsByRoleId(Integer roleId) {

        return menuMapper.getResUrlsByRoleId(roleId);
    }

    @Override
    public String findRoleNameByRoleId(Integer roleId) {

        return ConstantFactory.me().getSingleRoleName(roleId);
    }

    @Override
    public SimpleAuthenticationInfo info(ShiroUser shiroUser, User user, String realmName) {
        return null;
    }
}

