package com.example.cms;

import com.example.cms.modules.entity.User;
import com.example.cms.modules.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by losho on 2018-09-15.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseTest{


    @Autowired
    private UserMapper userMapper;


    @Test
    public void testMybatisPlus() {
        System.out.println(("----- selectAll method test ------"));
        List<User>userList = userMapper.selectList(null);
        System.out.println(userList);
    }
}
