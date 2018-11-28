package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.ViewPager;

import java.util.Map;

public interface ViewPagerService {
    public Map selectView(int page, int rows);
    public boolean insertView(ViewPager viewPager);
    public boolean deleteView(String id);
    public boolean updateView(ViewPager viewPager);
}
