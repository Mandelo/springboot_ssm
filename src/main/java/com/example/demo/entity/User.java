package com.example.demo.entity;

import lombok.Data;

/**
 * Created by losho on 2018-09-15.
 */

@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}