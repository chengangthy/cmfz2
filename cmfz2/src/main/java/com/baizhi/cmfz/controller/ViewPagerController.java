package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.ViewPager;
import com.baizhi.cmfz.service.ViewPagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/main")
public class ViewPagerController {

    @Autowired
    private ViewPagerService viewPagerService;

    @RequestMapping("/selectView")
    public @ResponseBody
    Map selectView(int page, int rows){
        //System.out.println(viewPagerService.selectView(page,rows));
        return viewPagerService.selectView(page,rows);
    }

    @RequestMapping("/insertView")
    public @ResponseBody boolean insertView(ViewPager viewPager, MultipartFile uploadFile, HttpServletRequest request) throws IOException {
        //获取文件名
        String filename=uploadFile.getOriginalFilename();

        //重命名
        String newName=new Date().getTime()+"_"+filename;

        //1路径
        String realPath = request.getSession().getServletContext().getRealPath("/img");
        //2.file对象
        File file = new File(realPath+"\\"+newName);
        //3.写入
        uploadFile.transferTo(file);
        viewPager.setImgPath(newName);
        String uuid = UUID.randomUUID().toString();
        viewPager.setId(uuid);
        viewPager.setDate(new Date());
        viewPager.setStatus("y");
        return viewPagerService.insertView(viewPager);
    }
    @RequestMapping("/deleteView")
    public @ResponseBody boolean deleteView(String id){
        return viewPagerService.deleteView(id);
    }

    @RequestMapping("/updateView")
    public @ResponseBody boolean updateView(ViewPager viewPager){
        return viewPagerService.updateView(viewPager);
    }

}
