package com.springboot.feign.service;

import org.json.JSONObject;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(url = "${localUrl}", name = "fileUpload")
public interface FileUploadService {

    @RequestMapping("hello")
    public JSONObject getHello();
}
