package com.example.cms.modules.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by losho on 2018-09-15.
 */

@Data
public class User {

    private int userId;//用户id
    private String username;//用户名
    private int gender;//性别
    private Date birth;//出生日期
    private String email;//邮箱
    private String phoneNumber;//电话
}