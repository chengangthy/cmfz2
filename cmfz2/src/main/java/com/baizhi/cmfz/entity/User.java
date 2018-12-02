package com.baizhi.cmfz.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.util.Date;

@Data
public class User {
    private String id;
    private String phoneNum;
    @Excel(name = "名字")
    private String username;
    private String password;
    private String salt;
    @Excel(name = "法名")
    private String dharmaName;
    @Excel(name = "省份")
    private String province;
    private String city;
    private String sex;
    private String sign;
    private String headPic;
    private int status;
    private Date date;
}
