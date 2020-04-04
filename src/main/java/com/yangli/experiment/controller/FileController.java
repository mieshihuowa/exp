package com.yangli.experiment.controller;

import com.baomidou.mybatisplus.extension.api.R;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.baomidou.mybatisplus.extension.api.ApiController;


import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

@CrossOrigin
@RestController
@RequestMapping("/file")
public class FileController extends ApiController {

    @RequestMapping("/upload")
    public R upload(@RequestParam("file") MultipartFile file,String sno) throws IOException {
//获取upload文件夹的路径
        String realPath = ("/Users/yangli/exp/"+sno);

        File fileUpload = new File(realPath);
        if (!fileUpload.exists()) {
            fileUpload.mkdirs();
        }
//将上传的文件写入 upload文件夹 中
        file.transferTo(new File(realPath,file.getOriginalFilename()));//文件上传

        return success("成功");
    }



    @RequestMapping("/download")
    public void download(String fileName, HttpServletResponse response) throws Exception {
//获取upload文件夹的路径
        String realPath = ("/Users/yangli/exp/1/"+ fileName);
//通过流读取文件
        FileInputStream is;
        is = new FileInputStream(new File(realPath));
//获得响应流
        ServletOutputStream os = response.getOutputStream();
//设置响应头信息
        response.setHeader("content-disposition","attachment;fileName="+ URLEncoder.encode(fileName,"UTF-8"));
//通过响应流将文件输入流读取到的文件写出
        IOUtils.copy(is,os);
//关闭流
        IOUtils.closeQuietly(is);
        IOUtils.closeQuietly(os);
    }
}
