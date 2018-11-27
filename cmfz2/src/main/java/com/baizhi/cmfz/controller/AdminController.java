package com.baizhi.cmfz.controller;


import com.baizhi.cmfz.entity.Admin;
import com.baizhi.cmfz.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/login")
    public String login(String username, String password, String kaptcha, HttpSession session){
        //取session验证码
        String kaptcha1=(String) session.getAttribute("kaptcha");
        //登录查询
        Admin admin = adminService.login(username, password);
        //比较
        boolean b=kaptcha1.equalsIgnoreCase(kaptcha);
        if(admin!=null&&b){
            session.setAttribute("admin", admin);
            return "main/main";
            //dasdas
        }
        return "login";

    }

}
