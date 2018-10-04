package com.example.cms.modules.service;

import com.example.cms.modules.entity.User;
import com.example.cms.modules.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ClassName UserService
 * @Description : TODO
 * @Author losh
 * @Date 2018-09-28 18:06
 * @Version 1.0
 */
public interface UserService {

    User selectByAccount(String account);
}
