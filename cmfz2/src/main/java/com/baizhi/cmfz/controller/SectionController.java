package com.baizhi.cmfz.controller;


import com.baizhi.cmfz.entity.Section;
import com.baizhi.cmfz.service.SectionService;
import com.baizhi.cmfz.utils.FileUtil;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.UUID;

@Controller
@RequestMapping("/main")
public class SectionController {

    @Autowired
    private SectionService sectionService;

    @RequestMapping("/insertSection")
    public @ResponseBody boolean insertSection(Section section, MultipartFile chapter, HttpServletRequest request) throws IOException {

        //webapp当前项目的路径
        String realPath = request.getSession().getServletContext().getRealPath("/");
        File file = new File(realPath + "/upload");
        if (!file.exists()) {
            //如果文件夹不存在创建一个
            file.mkdir();
        }
        //测试音乐.MP3   11111111.MP3   截断
        String extension = FilenameUtils.getExtension(chapter.getOriginalFilename());
        System.out.println(extension+"#############################");
        UUID uuid = UUID.randomUUID();
        String s = uuid.toString();
        String newName = s + "." + extension;

        //写入
        chapter.transferTo(new File(file.getAbsolutePath(), newName));
        //返回时长
        String langg= FileUtil.getDuration(new File(file.getAbsolutePath() + "/" + newName));
        //计算大小
        long size = chapter.getSize();
        double l = size / 1024.0 / 1024.0;
        String ssss= String.valueOf(l)+".Mb";

        System.out.println(l);


        //文件大小  时长  名字  url   date
        String id=UUID.randomUUID().toString();
        //id
        section.setId(id);
        //时长
        section.setDuration(langg);
        //大小
        section.setSize(ssss);
        //时间
        section.setUploadDate(new Date());
        //下载路径
        section.setDownpath(newName);

        return sectionService.insertSection(section);
    }
    @RequestMapping("/download")
    public void download(String url, String title,HttpServletRequest request, HttpServletResponse response) {
        //webapp当前项目的路径
        String uploadPath = request.getSession().getServletContext().getRealPath("upload");
        String path = uploadPath + "/" + url;
        //生成文件
        File file = new File(path);
        //拼接
        String s = title + "." + "mp3";

        try {
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(s, "utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        //响应
        response.setContentType("audio/mpeg");


        try {
            ServletOutputStream outputStream = response.getOutputStream();
            outputStream.write(FileUtils.readFileToByteArray(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
