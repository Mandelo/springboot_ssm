package com.example.cms.modules.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by losho on 2018-09-15.
 */

@Data
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;//用户id
    private String avatar;//头像
    private String name;//用户名
    private String account;//账户名
    private String password;//密码
    private String salt;//盐
    private int gender;//性别
    private Date birth;//出生日期
    private String email;//邮箱
    private String phoneNumber;//电话
    private String roleId;//角色id
    private Integer status;// 状态(1：启用  2：冻结  3：删除）
    private Date createTime;//创建时间
    private Integer deptid;//部门id

}