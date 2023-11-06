package com.springboot.ymloustsideconfig.controller;

import com.springboot.ymloustsideconfig.config.PersonConfig;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {

    @Resource
    private PersonConfig personConfig;

    @RequestMapping("configurationProperties")
    public String getCOnfiguration() {
        return personConfig.toString();
    }
}
