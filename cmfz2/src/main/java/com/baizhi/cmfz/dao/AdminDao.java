package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Admin;
import org.apache.ibatis.annotations.Param;

public interface AdminDao {
    public Admin login(@Param("username") String username,@Param("password") String password);
}
