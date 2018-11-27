package com.baizhi.cmfz.entity;

import lombok.Data;

import java.util.List;

@Data
public class Menu {
    private String id;
    private String title;
    private String iconcls;
    private String pid;
    private String url;
    private List<Menu> menulist;
}
