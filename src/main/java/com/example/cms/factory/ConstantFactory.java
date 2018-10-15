package com.example.cms.factory;

import com.example.cms.Util.SpringContextHolder;

/**
 * @ClassName ConstantFactory
 * @Description : TODO
 * @Author losh
 * @Date 2018-10-15 21:50
 * @Version 1.0
 */
public class ConstantFactory implements IConstantFactory {

    @Override
    public String getSingleRoleName(Integer roleId) {
        return null;
    }

    public static IConstantFactory me() {
        return SpringContextHolder.getBean("constantFactory");
    }
}

