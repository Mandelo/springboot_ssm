package com.example.cms.modules.controller;

import com.example.cms.modules.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

/**
 * @ClassName LoginController
 * @Description : TODO
 * @Author losh
 * @Date 2018-10-22 10:52
 * @Version 1.0
 */
public class LoginController {

    public String login(User user) {
        UsernamePasswordToken token = new UsernamePasswordToken(user.getAccount(),user.getPassword());
        Subject subject = SecurityUtils.getSubject();
        subject.login(token);
        Session session = subject.getSession();
        return "";
    }

}

