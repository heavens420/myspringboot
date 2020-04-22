package com.zlx.fastdfs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class UploadController {

    //文件保存目录
    String path = "C:/";
    @RequestMapping("/upload")
    public String upload(MultipartFile file) throws IOException {
        if (file.isEmpty()){
            return "文件不能为空";
        }
        File file1 = new File(path);
        if (!file1.exists()){
            file1.mkdir();
        }

        File dir = new File(path+file.getOriginalFilename());
        file.transferTo(dir);

        return "上传文件成功";
    }


}
