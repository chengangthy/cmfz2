package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.service.UserDTOService;
import com.baizhi.cmfz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/main")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserDTOService userDTOService;


    @RequestMapping("/selectCountt")
    public @ResponseBody
    Map SelectCountt(){
        return userService.selectCountt();
    }

    @RequestMapping("/selectSex")
    public @ResponseBody Map selectSex(){
        return userDTOService.selectSex();
    }
}
