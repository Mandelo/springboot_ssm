package com.example.cms.modules.entity;

import lombok.Data;

/**
 * @ClassName Menu
 * @Description : TODO
 * @Author losh
 * @Date 2018-10-27 22:32
 * @Version 1.0
 */
@Data
public class Menu {

    private Long id;

    private String code;

    private String pcode;
    private String pcodes;
    private String name;
    private String icon;
    private String url;
    private Integer num;
    private Integer levels;
    private Integer ismenu;
    private String tips;
    private Integer status;
    private Integer isopen;
}

