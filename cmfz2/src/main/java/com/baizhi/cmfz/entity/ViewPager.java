package com.baizhi.cmfz.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class ViewPager {
    private String id;
    private String title;
    private String imgPath;
    private String desc;
    private String status;
    @JsonFormat(pattern = "yyyy-MM-dd hh:ss:mm")
    private Date date;
}
