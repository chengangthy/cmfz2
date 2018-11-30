package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.AlbumDao;
import com.baizhi.cmfz.entity.Album;
import com.baizhi.cmfz.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("albumService")
@Transactional
public class AlbumServiceImpl implements AlbumService {


    @Autowired
    private AlbumDao albumDao;

    @Override
    public Map selectAlbum(int page,int rows) {
        int start=(page-1)*rows;
        List<Album> list=albumDao.selectAlbum(start,rows);
        int total=albumDao.selectAcount();
        Map map=new HashMap();
        map.put("rows",list);
        map.put("total",total);
        return map;
    }
}
