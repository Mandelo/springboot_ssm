package com.example.cms.Util;

import com.example.cms.modules.entity.ShiroUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

/**
 * @ClassName ShiroKit
 * @Description : TODO
 * @Author losh
 * @Date 2018-10-24 14:10
 * @Version 1.0
 */
public class ShiroKit {

    /**
     * @Description: 获取当前subject
     * @Param []
     * @Return org.apache.shiro.subject.Subject
     */
    public static Subject getSubject() {
        return SecurityUtils.getSubject();
    }

    /**
     * @Description: 获取封装的 ShiroUser
     * @Param []
     * @Return com.example.cms.modules.entity.ShiroUser
     */
  /*  public static ShiroUser getUser() {

        return (ShiroUser) getSubject().getPrincipals().getPrimaryPrincipal();
    }*/
}

