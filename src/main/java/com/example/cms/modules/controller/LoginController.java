package com.example.cms.modules.controller;

import com.example.cms.Util.HttpKit;
import com.example.cms.factory.ShiroFactory;
import com.example.cms.modules.entity.ShiroUser;
import com.example.cms.modules.entity.User;
import com.example.cms.modules.mapper.UserMapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName LoginController
 * @Description : 登录控制器
 * @Author losh
 * @Date 2018-10-22 10:52
 * @Version 1.0
 */
@Controller
public class LoginController {

    @Autowired
    UserMapper userMapper;

    @ResponseBody
    @RequestMapping(value = "doLogin", method = RequestMethod.POST)
    public String login() {
        String account = HttpKit.getRequest().getParameter("account");
        String password = HttpKit.getRequest().getParameter("password");
        UsernamePasswordToken token = new UsernamePasswordToken(account, password);
        Subject currentUser = SecurityUtils.getSubject();
        System.out.println(currentUser.toString());
        currentUser.login(token);
        Session session = currentUser.getSession();
        User user = userMapper.selectByAccount(account);
        ShiroUser shiroUser = ShiroFactory.me().convToShiroUser(user);
        session.setAttribute("shiroUser", shiroUser);
        session.setAttribute("account", shiroUser.getAccount());
        System.out.println(shiroUser);
        return "success";
    }
}

