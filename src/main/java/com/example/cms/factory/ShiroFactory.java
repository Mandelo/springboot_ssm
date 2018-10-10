package com.example.cms.factory;

import com.example.cms.Util.Convert;
import com.example.cms.Util.SpringContextHolder;
import com.example.cms.modules.entity.Dept;
import com.example.cms.modules.entity.ShiroUser;
import com.example.cms.modules.entity.User;
import com.example.cms.modules.mapper.DeptMapper;
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
 * @Description : TODO
 * @Author losh
 * @Date 2018-10-04 21:50
 * @Version 1.0
 */
@Service
@DependsOn("SpringContextHolder")
@Transactional(readOnly = true)
public class ShiroFactory implements IShiro {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DeptMapper deptMapper;

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
    public ShiroUser shiroUser(User user) {
        ShiroUser shiroUser = new ShiroUser();
        shiroUser.setId(user.getId());
        Dept dept = deptMapper.selectById(user.getId());
        shiroUser.setAccount(user.getAccount());
        shiroUser.setDeptId(user.getDeptid());
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

        return null;
    }

    @Override
    public List<String> findPermissionsByRoleUd(Integer roleId) {
        return null;
    }

    @Override
    public String findRoleNameByRoleId(Integer roleId) {
        return null;
    }

    @Override
    public SimpleAuthenticationInfo info(ShiroUser shiroUser, User user, String realmName) {
        return null;
    }
}

