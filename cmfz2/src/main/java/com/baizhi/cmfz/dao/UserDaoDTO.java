package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.UserDTO;

import java.util.List;

public interface UserDaoDTO {
    public List<UserDTO> selectMan();
    public List<UserDTO> selectWoMan();
}
