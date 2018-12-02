package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.UserDao;
import com.baizhi.cmfz.entity.User;
import com.baizhi.cmfz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {


    @Autowired UserService userService;
    @Autowired
    private UserDao userDao;

    @Override
    public int selectCount1() {
        return userDao.selectCount1();
    }

    @Override
    public int selectCount2() {
        return userDao.selectCount2();
    }

    @Override
    public int selectCount3() {
        return userDao.selectCount3();
    }

    @Override
    public Map selectCountt() {
        int count1 = userService.selectCount1();
        int count2 = userService.selectCount2();
        int count3 = userService.selectCount3();
        int[] count={count1,count2,count3};

        Map map=new HashMap();
        map.put("count",count);
        String[] ply={"一周","两周","三周"};
        map.put("ply",ply);
        return map;
    }

    @Override
    public Map selectUser(int page,int rows) {

        int start=(page-1)*rows;
        List<User> list=userDao.selectUser(start,rows);
        int count=userDao.selectUserCount();
        Map map =new HashMap();
        map.put("total",count);
        map.put("rows",list);
        return map;
    }

    @Override
    public List<User> selectExcel() {
        return userDao.selectExcel();
    }
}
