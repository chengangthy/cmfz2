package com.baizhi.cmfz.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.baizhi.cmfz.dao.UserDao;
import com.baizhi.cmfz.entity.User;
import com.baizhi.cmfz.service.UserDTOService;
import com.baizhi.cmfz.service.UserService;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/main")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    UserDao userDao;

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


    @RequestMapping("/selectUser")
    public @ResponseBody Map selectUser(int page,int rows){
        return userService.selectUser(page,rows);
    }


    /**
     * exceldaochu
     * 导出相当于下载
     */

    @RequestMapping("/exceldaochu")
    public @ResponseBody boolean exceldaochu(HttpServletResponse response){
        try {
        //设置导出类型
        response.setHeader("content-Type", "application/vnd.ms-excel");
        //response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition","attachment;filename=user.xls");
        List<User> list= userService.selectExcel();
        ExportParams exportParams=new ExportParams();
        //工作簿
        Workbook workbook= ExcelExportUtil.exportExcel(exportParams,User.class,list);

            workbook.write(response.getOutputStream());
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }


    }
}
