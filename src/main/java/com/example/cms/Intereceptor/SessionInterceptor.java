package com.example.cms.Intereceptor;

import com.example.cms.factory.IShiro;
import com.example.cms.factory.ShiroFactory;
import com.example.cms.modules.entity.ShiroUser;
import com.example.cms.modules.entity.User;
import com.example.cms.modules.mapper.UserMapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName SessionIntereceptor 拦截自动登录
 * @Description : TODO
 * @Author losh
 * @Date 2018-11-09 21:38
 * @Version 1.0
 */
public class SessionInterceptor implements HandlerInterceptor {
    private final Logger logger = LoggerFactory.getLogger(SessionInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        logger.info("---preHandle---");
        Subject currentUser = SecurityUtils.getSubject();
        //判断用户是通过记住我功能自动登录,此时session失效
        if (!currentUser.isAuthenticated() && currentUser.isRemembered()) {
            //默认获取info第一个参数即shiroUser
            ShiroUser shiroUser = (ShiroUser) currentUser.getPrincipal();
            Session session = currentUser.getSession();
            session.setAttribute("shiroUser", shiroUser);
        }
        return true;
    }

}

