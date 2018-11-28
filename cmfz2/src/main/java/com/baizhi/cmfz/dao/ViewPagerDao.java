package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.ViewPager;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ViewPagerDao {
    public List<ViewPager> selectView(@Param("start") int start, @Param("rows") int rows);

    public int selectCount();

    public void deleteView(String id);

    public void insertView(ViewPager viewPager);

    public void updateView(ViewPager viewPager);
}
