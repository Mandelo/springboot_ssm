package com.example.cms.modules.entity;

import lombok.Data;

/**
 * Created by losh on 2018-09-28.
 */
@Data
public class Role {

    private Integer id;
    /**
     * 序号
     */
    private Integer num;
    /**
     * 父角色id
     */
    private Integer pid;
    /**
     * 角色名称
     */
    private String name;
    /**
     * 部门名称
     */
    private Integer deptid;
    /**
     * 提示
     */
    private String tips;
    /**
     * 保留字段(暂时没用）
     */
    private Integer version;

}
