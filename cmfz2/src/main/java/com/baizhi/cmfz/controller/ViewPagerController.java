package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.service.ViewPagerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/main")
public class ViewPagerController {

    private ViewPagerService viewPagerService;

    @RequestMapping("/selectView")
    public @ResponseBody
    Map selectView(int page, int rows){
        return viewPagerService.selectView(page,rows);
    }
}
