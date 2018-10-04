package com.example.cms.modules.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName ShiroUser
 * @Description :  自定义Authentication对象，使得Subject除了携带用户的登录名外还可以携带更多信息
 * @Author losh
 * @Date 2018-10-02 11:37
 * @Version 1.0
 */
@Data
public class ShiroUser implements Serializable{

    private static final long serialVersionUID = 1L;
    private Integer id;//主键ID
    private String account;//账号
    private String name;//用户名字
    private Integer deptId;//部门id
    private List<Integer> roleList;//角色集合
    private  String deptName;//部门名称
    private List<String> roleNames;//用户名称集

}

