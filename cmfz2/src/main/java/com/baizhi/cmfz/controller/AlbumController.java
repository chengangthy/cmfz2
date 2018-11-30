package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/main")
public class AlbumController {

    @Autowired
    private AlbumService albumService;
    @RequestMapping("/selectAlbum")
    public @ResponseBody
    Map selectAlbum(int page, int rows){
        return albumService.selectAlbum(page,rows);
    }
}
