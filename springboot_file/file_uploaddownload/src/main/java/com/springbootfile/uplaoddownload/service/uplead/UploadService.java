package com.springbootfile.uplaoddownload.service.uplead;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface UploadService {

    public String upload(MultipartFile file) throws IOException;

    public List<String> uploadByMap(Map<String, MultipartFile> files) throws IOException;

    public List<String> uploadByMultipartFileList(List<MultipartFile> fileList) throws IOException;
}
