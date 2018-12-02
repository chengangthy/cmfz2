package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    public int selectCount1();
    public int selectCount2();
    public int selectCount3();

    List<User> selectUser(@Param("start") int start,@Param("rows") int rows);

    int selectUserCount();
    List<User> selectExcel();
}
