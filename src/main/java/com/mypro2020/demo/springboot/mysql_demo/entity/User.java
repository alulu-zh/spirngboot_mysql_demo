package com.mypro2020.demo.springboot.mysql_demo.entity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class User {
    private Integer id;
    private String userName;
    private String passWord;
    private String realName;
}
