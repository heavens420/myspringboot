package com.zlx.fastdfs.utils;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.charset.Charset;

@Component
public class fastdfs {

    @Autowired
    private FastFileStorageClient storageClient;

    //返回文件上传成功后的名称
    private String getRealAccessUrl(StorePath storePath) {
        String fileUrl = storePath.getFullPath();
        return fileUrl;
    }

    //Mutipart类型文件上传
    public String UploadFile(MultipartFile multipartFile) throws IOException {
        StorePath storePath = storageClient.uploadFile(
                multipartFile.getInputStream(), multipartFile.getSize(),
                FilenameUtils.getExtension(multipartFile.getOriginalFilename()), null);
        return getRealAccessUrl(storePath);
    }

    //普通文件上传
    public String uploadFile(File file) throws FileNotFoundException {
        FileInputStream inputStream = new FileInputStream(file);
        StorePath storePath = storageClient.uploadFile(inputStream, file.length(),
                FilenameUtils.getExtension(file.getName()), null);
        return getRealAccessUrl(storePath);
    }

    //带输入流形式的文件上传
    public String uploadFile(InputStream inputStream, long size, String fileName) {
        StorePath storePath = storageClient.uploadFile(inputStream, size, fileName,null);
        return getRealAccessUrl(storePath);
    }

    //将一般文本上传到fastdfs服务器
    public String uploadFile(String content, String fileExtension) {
        byte[] buff = content.getBytes(Charset.forName("UTF-8"));
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(buff);
        StorePath storePath = storageClient.uploadFile(byteArrayInputStream, buff.length, fileExtension, null);
        return getRealAccessUrl(storePath);
    }
}
