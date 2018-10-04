package com.example.cms.modules.service.impl;

import com.example.cms.modules.entity.User;
import com.example.cms.modules.mapper.UserMapper;
import com.example.cms.modules.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserServiceImpl
 * @Description : TODO
 * @Author losh
 * @Date 2018-09-28 18:08
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;


    @Override
    public User selectByAccount(String account) {
        return null;
    }
}

