package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    public int selectCount1();
    public int selectCount2();
    public int selectCount3();
    public Map selectCountt();
    Map selectUser(int page,int rows);
    List<User> selectExcel();
}
