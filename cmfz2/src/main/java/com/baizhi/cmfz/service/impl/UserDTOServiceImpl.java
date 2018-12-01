package com.baizhi.cmfz.service.impl;



import com.baizhi.cmfz.dao.UserDaoDTO;
import com.baizhi.cmfz.entity.UserDTO;
import com.baizhi.cmfz.service.UserDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("userDTOService")
@Transactional
public class UserDTOServiceImpl implements UserDTOService {

    @Autowired
    private UserDaoDTO userDaoDTO;
    @Override
    public Map selectSex() {
        Map map=new HashMap();
        List<UserDTO> list = userDaoDTO.selectMan();
        map.put("man",list);
        List<UserDTO> list2=userDaoDTO.selectWoMan();
        map.put("woman",list2);
        return map;
    }
}
