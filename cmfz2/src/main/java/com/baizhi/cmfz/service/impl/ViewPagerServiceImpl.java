package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.ViewPagerDao;
import com.baizhi.cmfz.entity.ViewPager;
import com.baizhi.cmfz.service.ViewPagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("viewPagerService")
@Transactional
public class ViewPagerServiceImpl implements ViewPagerService {

   @Autowired
   private ViewPagerDao viewPagerDao;
    @Override
    public Map selectView(int page, int rows) {
        int start=(page-1)*rows;
        List<ViewPager> list=viewPagerDao.selectView(start,rows);
        int total=viewPagerDao.selectCount();

        Map map =new HashMap();
        map.put("rows",list);
        map.put("total",total);
        return map;
    }

    @Override
    public boolean insertView(ViewPager viewPager) {

        try {

            viewPagerDao.insertView(viewPager);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteView(String id) {

        try {
            viewPagerDao.deleteView(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateView(ViewPager viewPager) {
        try {
            viewPagerDao.updateView(viewPager);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
}
