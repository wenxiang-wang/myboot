package com.springboot.resttemplate.controller;

import com.springbootconnector.interfacewrapper.ResponseResult;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Log4j2
@RestController
public class RestTemplateController {

    @Value("${localUrl}")
    private String localUrl;

    @RequestMapping("toGetRestTemplate")
    public ResponseResult getForObjectone() {
        RestTemplate restTemplate = new RestTemplate();
        Map<String, Object> parmamMap = new HashMap<>();
        log.info("get");
        return ResponseResult.success(restTemplate.getForObject(localUrl, String.class, parmamMap));
    }

    @RequestMapping("toPostRestTemplate")
    public ResponseResult postForObjectone() {
        RestTemplate restTemplate = new RestTemplate();
        Map<String, Object> parmamMap = new HashMap<>();
        log.info("post");
        return ResponseResult.success(restTemplate.postForObject(localUrl, parmamMap, String.class));
    }
}
