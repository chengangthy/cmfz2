package com.baizhi.cmfz.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private String id;
    private String phoneNum;
    private String username;
    private String password;
    private String salt;
    private String dharmaName;
    private String province;
    private String city;
    private String sex;
    private String sign;
    private String headPic;
    private int status;
    private Date date;
}
