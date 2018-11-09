package com.example.cms.Util;

import com.example.cms.modules.entity.ShiroUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;

/**
 * @ClassName ShiroKit
 * @Description : TODO
 * @Author losh
 * @Date 2018-10-24 14:10
 * @Version 1.0
 */
public class ShiroKit {
    private static final String NAMES_DELIMETER = ",";

    /**
     * 加盐参数
     */
    public final static String hashAlgorithmName = "MD5";

    /**
     * 循环次数
     */
    public final static int hashIterations = 1024;

    /**
     * @Description: 获取当前subject
     * @Param []
     * @Return org.apache.shiro.subject.Subject
     */
    public static Subject getSubject() {
        return SecurityUtils.getSubject();
    }

    public static String md5(String credentials, String saltSource) {
        ByteSource salt = new Md5Hash(saltSource);
        return new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations).toString();
    }
}

