package com.example.cms.modules.entity;

import lombok.Data;

/**
 * @ClassName Relation
 * @Description : TODO
 * @Author losh
 * @Date 2018-10-28 20:47
 * @Version 1.0
 */
@Data
public class Relation {

    private Integer id;

    /**
     * 菜单id
     */
    private Long menuid;

    /**
     * 角色id
     */
    private Integer roleid;
}

