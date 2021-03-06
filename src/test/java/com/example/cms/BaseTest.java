package com.example.cms;

import com.example.cms.factory.ConstantFactory;
import com.example.cms.factory.IConstantFactory;
import com.example.cms.factory.IShiro;
import com.example.cms.factory.ShiroFactory;
import com.example.cms.modules.entity.Dept;
import com.example.cms.modules.entity.User;
import com.example.cms.modules.mapper.DeptMapper;
import com.example.cms.modules.mapper.MenuMapper;
import com.example.cms.modules.mapper.RoleMapper;
import com.example.cms.modules.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @ClassName BaseTest
 * @Description : 测试类
 * @Author losh
 * @Date 2018-09-28 19:59
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseTest {


    @Autowired
    UserMapper userMapper;

    @Autowired
    DeptMapper deptMapper;

    @Autowired
    MenuMapper menuMapper;

    @Autowired
    RoleMapper roleMapper;

    Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * @Description: 测试mybatisPlus内置方法
     * @Param []
     * @Return void
     */
    @Test
    public void testMybatisPlus() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        System.out.println(userList);
    }

    /**
     * @Description: 测试自定义Mapper
     * @Param []
     * @Return void
     */
    @Test
    public void testSelectByAccount() {
        User user = userMapper.selectByAccount("admin");
        log.info("\n----------------------->" + user.toString() + "<----------------------------");
    }

    /**
     * @Description: 测试静态工厂方法
     * @Param []
     * @Return void
     */
    @Test
    public void testConstantFactory() {
        IConstantFactory constantFactory = ConstantFactory.me();
        String salt = constantFactory.getSaltByAccount("admin");
        System.out.println(salt + "-------------测试静态工厂方法--------------------");
    }

    /**
     * @Description: 测试shiroFactory工厂
     * @Param []
     * @Return void
     */
    @Test
    public void testShiroFactory() {
        IShiro shiroFactory = ShiroFactory.me();//
        User user = shiroFactory.user("admin");
        System.out.println(user);
    }

    /**
    *  @Description: 测试deptMapper
    *  @Param []
    *  @Return void
    */
    @Test
    public void testDeptDao(){
       Dept dept =  deptMapper.selectById(1);
        System.out.println(dept);
    }

    @Test
    public void testFindPermissionByRoleId(){
        IShiro iShiro = ShiroFactory.me();
       List<String> l =  iShiro.findPermissionsByRoleId(1);
        System.out.println("\n");
        System.out.println("---------------------------------------------"+l+"--------------------------");
    }

    @Test
    public void testRoleMapper(){
        IConstantFactory constantFactory = ConstantFactory.me();
       String roleName =  constantFactory.getSingleRoleName(1);
        log.info("\n"+roleName);
    }

    @Test
    public void testUserMapper(){
        User user = userMapper.selectByAccount("admin");
        System.out.println(user);
    }
}

