package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.SectionDao;
import com.baizhi.cmfz.entity.Section;
import com.baizhi.cmfz.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("sectionService")
@Transactional
public class SectionServiceImpl implements SectionService {

    @Autowired
    private SectionDao sectionDao;

    @Override
    public boolean insertSection(Section section) {
        try {
            sectionDao.insertSection(section);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
