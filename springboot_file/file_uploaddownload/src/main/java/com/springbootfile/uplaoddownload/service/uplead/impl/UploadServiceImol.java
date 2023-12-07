package com.springbootfile.uplaoddownload.service.uplead.impl;

import com.springbootfile.uplaoddownload.service.uplead.UploadService;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
@Service("uploadService")
@ConfigurationProperties(prefix = "spring.servlet.multipart")
public class UploadServiceImol implements UploadService {

    private String location;

    @Override
    public String upload(MultipartFile file) throws IOException {
        if (StringUtils.isEmpty(location)) {
            location = ResourceUtils.getURL("classpath:").getPath().split("target")[0] + "uploads";
        }


        File newFile = new File(location);
        // 如果文件夹不存在、则新建
        if (!newFile.exists()) newFile.mkdirs();

        File targetFile = new File(newFile, file.getOriginalFilename());
        // 上传
        file.transferTo(targetFile);
        return targetFile.getPath();
    }

    @Override
    public List<String> uploadByMap(Map<String, MultipartFile> files) throws IOException {
        List<String> returnList = new ArrayList<>();
        for (MultipartFile file : files.values()) {
            returnList.add(upload(file));
        }
        return returnList;
    }

    @Override
    public List<String> uploadByMultipartFileList(List<MultipartFile> fileList) throws IOException {
        List<String> returnList = new ArrayList<>();
        for (MultipartFile file : fileList) {
            returnList.add(upload(file));
        }
        return returnList;
    }
}
