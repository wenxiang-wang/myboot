package com.springbootfile.uplaoddownload.controller;


import com.springbootconnector.interfacewrapper.ResponseResult;
import com.springbootfile.uplaoddownload.service.uplead.UploadService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.thymeleaf.util.ListUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class FileUploadController {

    private final static Logger log = LoggerFactory.getLogger(FileUploadController.class);

    @Resource
    private UploadService uploadService;

    @RequestMapping("uploadByMultipartFile")
    public ResponseResult upload(MultipartFile file) {
        String returnString = null;
        try {
            returnString = uploadService.upload(file);
            return ResponseResult.success(returnString);
        } catch (IOException e) {
            e.printStackTrace();
            log.error("文件上传失败！: {}", e);
            return ResponseResult.fail("系统异常，文件上传失败");
        }

    }

    @RequestMapping("/uploadMultipartFileList")
    public ResponseResult uploadMultipartFileList(@RequestParam("files") List<MultipartFile> fileList) {
        try {
            List<String> returnStringList = uploadService.uploadByMultipartFileList(fileList);
            if (ListUtils.isEmpty(returnStringList)) {
                return ResponseResult.fail("文件上传失败！");
            }
            return ResponseResult.success(returnStringList);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("系统异常，文件上传失败！", e);
            return ResponseResult.fail("系统异常，文件上传失败！");
        }
    }

    @RequestMapping("/uploadByRequest")
    public ResponseResult uploadByRequest(HttpServletRequest request) {
        try {
            Map<String, MultipartFile> files = new HashMap<>();

            if (request instanceof MultipartHttpServletRequest) {
                MultipartHttpServletRequest req = (MultipartHttpServletRequest) request;
                MultiValueMap<String, MultipartFile> multiValueMap = req.getMultiFileMap();
                if (multiValueMap != null && !multiValueMap.isEmpty()) {
                    for (String key : multiValueMap.keySet()) {
                        files.put(key, multiValueMap.getFirst(key));
                    }
                }
            }
            if (files.isEmpty())
                return ResponseResult.fail("文件木有？");

            List<String> returnStringList = uploadService.uploadByMap(files);
            if (ListUtils.isEmpty(returnStringList)) {
                return ResponseResult.fail("文件上传失败！");
            }
            return ResponseResult.success(returnStringList);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseResult.fail("系统异常，文件上传失败！");
        }
    }
}
