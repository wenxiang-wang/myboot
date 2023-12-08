package com.springboot.feign.controller;

import com.springboot.feign.service.FileUploadService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {

    @Resource
    private FileUploadService fileUploadService;

    @RequestMapping("toGetJson")
    public String doPostGetJson() {
        return fileUploadService.getHello().toString();
    }
}
